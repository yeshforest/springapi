package com.example.apidemo.controller;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchParam {
    @Schema(description = "사용자 계정이름",example = "hellobuilder1")
    private String account;
    @Schema(description = "사용자 이메일",example = "abc@pipebuilders.com")
    private String email;
    @Schema(description = "요청할 페이지",defaultValue = "1",example = "30")
    private int page;
}
