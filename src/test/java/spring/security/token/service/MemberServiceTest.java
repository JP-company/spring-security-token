package spring.security.token.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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
}