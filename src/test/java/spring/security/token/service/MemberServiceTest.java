package spring.security.token.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import spring.security.token.domain.Member;
import spring.security.token.domain.Role;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;


    @DisplayName("일반 회원 저장 테스트")
    @Test
    void member_save_test() {
        // given
        String loginId = "wjsdj2009";
        String loginPassword = "Qwer1234!";

        // when, then
        Long savedMemberId = memberService.save(loginId, loginPassword);

        // then
        assertThat(savedMemberId).isEqualTo(1L);
    }

    @DisplayName("회원에게 어드민 권한 부여 테스트")
    @Test
    void member_set_admin() {
        // given
        String loginId = "wjsdj2009";
        String loginPassword = "Qwer1234!";
        Long savedMemberId = memberService.save(loginId, loginPassword);

        // when
        memberService.setAdminMember(savedMemberId);

        // then
        Member member = memberService.findMember(savedMemberId);
        assertThat(member.getRole()).isEqualTo(Role.ADMIN);
    }

    @DisplayName("전체 회원 조회 테스트")
    @Test
    void all_member_find() {
        // given
        String loginId = "wjsdj2009";
        String loginPassword = "Qwer1234!";
        memberService.save(loginId, loginPassword);

        // when
        List<Member> members = memberService.findMembers();

        // then
        assertThat(members.size()).isEqualTo(1);
    }
}