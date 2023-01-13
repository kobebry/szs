package ai.szs.szsapi.user.service;


import ai.szs.szsapi.common.model.ResponseObject;
import ai.szs.szsapi.db.domain.Member;
import ai.szs.szsapi.db.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final MemberRepository memberRepository;

    public Member getMemberInfo(String memberIdx){
        return memberRepository.findById(Long.parseLong(memberIdx)).get();
    }
}
