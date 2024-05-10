package spring.security.token.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.security.token.controller.dto.request.MemberJoinForm;
import spring.security.token.controller.dto.response.ResponseDto;
import spring.security.token.controller.dto.response.ResponseListDto;
import spring.security.token.domain.Member;
import spring.security.token.service.MemberService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<ResponseDto<Long>> memberJoin(
            @Valid @RequestBody MemberJoinForm memberJoinForm
    ) {
        Long savedMemberId = memberService.save(memberJoinForm.loginId(), memberJoinForm.loginPassword());

        ResponseDto<Long> responseBody = ResponseDto.<Long>builder()
                .data(savedMemberId)
                .build();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/members/{memberId}")
    public ResponseEntity<ResponseDto<Member>> getMember(
            @PathVariable Long memberId
    ) {
        Member member = memberService.findMember(memberId);

        ResponseDto<Member> responseBody = ResponseDto.<Member>builder()
                .data(member)
                .build();
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/members")
    public ResponseEntity<ResponseListDto<Member>> getMembers() {
        List<Member> members = memberService.findMembers();

        ResponseListDto<Member> responseBody = ResponseListDto.<Member>builder()
                .data(members)
                .build();
        return ResponseEntity.ok(responseBody);
    }
}
