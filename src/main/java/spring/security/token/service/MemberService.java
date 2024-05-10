package spring.security.token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.security.token.domain.Member;
import spring.security.token.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long save(String loginId, String loginPassword) {
        Member member = Member.create(loginId, loginPassword);
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
}
