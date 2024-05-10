package spring.security.token.controller.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MemberJoinForm(
        @NotBlank
        String loginId,
        @NotBlank
        String loginPassword
) {
}
