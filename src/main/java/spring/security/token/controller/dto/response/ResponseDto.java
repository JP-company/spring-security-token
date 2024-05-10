package spring.security.token.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseDto<T> {
    private T data;

    @Builder.Default
    private int code = 200;

    @Builder.Default
    private String message = "";
}
