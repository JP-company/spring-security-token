package spring.security.token.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.security.token.domain.Member;
import spring.security.token.repository.MemberRepository;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long save(String loginId, String loginPassword) {
        Member member = Member.create(loginId, loginPassword);
        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }

    @Transactional
    public void setAdminMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("없는 회원"));
        member.setAdminRole();
    }

}
