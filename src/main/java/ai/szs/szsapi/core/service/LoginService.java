package ai.szs.szsapi.core.service;

import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.core.model.LoginGetDto;
import ai.szs.szsapi.core.model.LoginSetDto;
import ai.szs.szsapi.db.domain.Member;
import ai.szs.szsapi.db.repository.MemberRepository;
import ai.szs.szsapi.utill.AES256;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {

    private final MemberRepository memberRepository;

    private final AES256 aes256;

    public ResponseObject login(LoginSetDto loginSetDto){
        log.info("[batiLogin] : {}", loginSetDto);

        /* 유효성 검사 */
        if(loginSetDto.getMId().equals("")){
            return new ResponseObject("9999", "아이디를 입력해주세요");
        }
        if(loginSetDto.getPassword().equals("")){
            return new ResponseObject("9999", "비밀번호를 입력해주세요");
        }

        /* 1.email 등록여부 조회 */
        Optional<Member> memberResult = memberRepository.findBymId(loginSetDto.getMId());

        /* 2.조회 결과 */
        if(memberResult.isEmpty()){
            return new ResponseObject("9999", "일치하는 계정정보가 없습니다.");
        }

        /* 3.비밀번호 체크 */
        if(!BCrypt.checkpw(loginSetDto.getPassword(), memberResult.get().getHashed_password())){
            return new ResponseObject("9999", "비밀번호가 올바르지 않습니다. 비밀번호를 다시 확인해주세요");
        }

        /* 5.Member lastLoginDate update */
        memberResult.ifPresent(member->{
            member.setLastLoginDate(LocalDateTime.now());
            memberRepository.save(member);
        });

        return new ResponseObject("0000", "로그인 성공",
                LoginGetDto.builder()
                        .mIdx(memberResult.get().getMIdx())
                        .mId(memberResult.get().getMId())
                        .mName(memberResult.get().getMName())
                        .email(memberResult.get().getEmail())
                        .memberType(memberResult.get().getMemberType())
                        .build());
    }

}
