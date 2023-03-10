package ai.szs.szsapi.signup.service;

import ai.szs.szsapi.common.enums.CommonException;
import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.signup.model.SignUpSetDto;
import ai.szs.szsapi.db.domain.Member;
import ai.szs.szsapi.db.domain.MemberAvailable;
import ai.szs.szsapi.db.repository.MemberAvailableRepository;
import ai.szs.szsapi.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SignUpService {

    private final MemberRepository memberRepository;

    private final MemberAvailableRepository memberAvailableRepository;

    public ResponseObject signUp(SignUpSetDto signUpSetDto){
        log.info("[signUp] : {}", signUpSetDto);

        /* 유효성 검사 */
        if(StringUtils.isEmpty(signUpSetDto.getUserId())){
            return new ResponseObject(CommonException.SIGNUP_PARAM_VALID_ERROR.getResultcode(), CommonException.SIGNUP_PARAM_VALID_ERROR.getResultMessage() + " 아이디");
        }
        if(StringUtils.isEmpty(signUpSetDto.getPassword())){
            return new ResponseObject(CommonException.SIGNUP_PARAM_VALID_ERROR.getResultcode(), CommonException.SIGNUP_PARAM_VALID_ERROR.getResultMessage() + " 패스워드");
        }
        if(StringUtils.isEmpty(signUpSetDto.getName())){
            return new ResponseObject(CommonException.SIGNUP_PARAM_VALID_ERROR.getResultcode(), CommonException.SIGNUP_PARAM_VALID_ERROR.getResultMessage() + " 이름");
        }
        if(StringUtils.isEmpty(signUpSetDto.getRegNo())){
            return new ResponseObject(CommonException.SIGNUP_PARAM_VALID_ERROR.getResultcode(), CommonException.SIGNUP_PARAM_VALID_ERROR.getResultMessage() + " 주민등록번호");
        }

        /* 1.등록가능 유저 확인 */
        Optional<MemberAvailable> memberAvailable = memberAvailableRepository.findByNameAndRegNo(signUpSetDto.getName(),signUpSetDto.getRegNo());

        /* 2.등록가능 유저 확인 결과 */
        if(memberAvailable.isEmpty()){
            return new ResponseObject(CommonException.SIGNUP_NOT_AVAILABLE_USER.getResultcode(), CommonException.SIGNUP_NOT_AVAILABLE_USER.getResultMessage());
        }

        /* 3.회원 등록여부 조회 */
        Optional<Member> memberResult = memberRepository.findByUserId(signUpSetDto.getUserId());

        /* 4.조회 결과 */
        if(!memberResult.isEmpty()){
            return new ResponseObject(CommonException.SIGNUP_ALREADY_MEMBER.getResultcode(), CommonException.SIGNUP_ALREADY_MEMBER.getResultMessage());
        }

        /* 5.Member insert */
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Member member = Member.builder()
                            .userId(signUpSetDto.getUserId())
                            .name(signUpSetDto.getName())
                            .password(encoder.encode(signUpSetDto.getPassword()))//hash 암호화
                            .regNo(encoder.encode(signUpSetDto.getRegNo()))//hash 암호화
                            .build();

        memberRepository.save(member);

        /* response */
        return new ResponseObject(CommonException.SUCCESS.getResultcode(), CommonException.SUCCESS.getResultMessage());
    }
}
