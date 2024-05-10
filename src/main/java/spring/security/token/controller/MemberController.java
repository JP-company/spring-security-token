package spring.security.token.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.security.token.controller.dto.request.MemberJoinForm;
import spring.security.token.controller.dto.response.ResponseDto;
import spring.security.token.service.MemberService;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<ResponseDto<Long>> memberJoin(
            @Valid @RequestBody MemberJoinForm memberJoinForm
    ) {
        Long savedMemberId = memberService.save(memberJoinForm.loginId(), memberJoinForm.loginPassword());

        ResponseDto<Long> responseBody = ResponseDto.<Long>builder()
                .data(savedMemberId)
                .build();
        return ResponseEntity.ok(responseBody);
    }
}
