package com.example.apidemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Schema(description = "토큰 재발급 요청 DTO")
public class TokenRequestDto {
    @Schema(description = "accessToken",example = "leyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY5OTI4MDE1N30.pAWSKZsC2U4HGmH3CLHeU8Q7cu-6sYQFnQNHqE55Vvqa6SwuLSxz49P-m9bHobhOALnBpsH2ZwF-1UjrETIu0g")
    private String accessToken;
    @Schema(description = "refreshToken",example = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2OTk4ODMxNTd9.W7QWTIj3eWlNl1hWw8sXMNNok_pyean73VtSj_210bABTdBiaNU4xtlBOyUCW-IE-YHlEJ_h3p-sExhVxUC6Sg")
    private String refreshToken;
}