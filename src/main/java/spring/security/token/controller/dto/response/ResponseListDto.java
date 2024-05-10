package spring.security.token.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ResponseListDto<T> {
    private List<T> data;

    @Builder.Default
    private int code = 200;

    @Builder.Default
    private String message = "";
}