package ai.szs.szsapi.login.service;

import ai.szs.szsapi.common.enums.CommonException;
import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.config.JwtTokenProvider;
import ai.szs.szsapi.login.model.LoginSetDto;
import ai.szs.szsapi.login.model.LoginGetDto;
import ai.szs.szsapi.db.domain.Member;
import ai.szs.szsapi.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;

    private final JwtTokenProvider jwtTokenProvider;

    public ResponseObject login(LoginSetDto loginSetDto){
        log.info("[login] : {}", loginSetDto);

        /* 유효성 검사 */
        if(StringUtils.isEmpty(loginSetDto.getUserId())){
            return new ResponseObject(CommonException.LOGIN_PARAM_VALID_ERROR.getResultcode(), CommonException.LOGIN_PARAM_VALID_ERROR.getResultMessage() + " 아이디");
        }
        if(StringUtils.isEmpty(loginSetDto.getPassword())){
            return new ResponseObject(CommonException.LOGIN_PARAM_VALID_ERROR.getResultcode(), CommonException.LOGIN_PARAM_VALID_ERROR.getResultMessage() + " 패스워드");
        }

        /* 1.userId 등록여부 조회 */
        Optional<Member> memberResult = memberRepository.findByUserId(loginSetDto.getUserId());

        /* 2.조회 결과 */
        if(memberResult.isEmpty()){
            return new ResponseObject(CommonException.LOGIN_NOT_IN_USER.getResultcode(), CommonException.LOGIN_NOT_IN_USER.getResultMessage());
        }

        /* 3.비밀번호 체크 */
        if(!BCrypt.checkpw(loginSetDto.getPassword(), memberResult.get().getPassword())){
            return new ResponseObject(CommonException.LOGIN_NOT_EQUAL_PASSWORD.getResultcode(), CommonException.LOGIN_NOT_EQUAL_PASSWORD.getResultMessage());
        }

        return new ResponseObject("0000", "로그인 성공",
                LoginGetDto.builder()
                        .jwtToken(jwtTokenProvider.createToken(String.valueOf(memberResult.get().getMemberIdx())))
                        .build());
    }

}
