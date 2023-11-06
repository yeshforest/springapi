package com.example.apidemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Schema(description = "로그인, 토큰 재발급 시 토큰정보 응답 DTO")
public class TokenDto {
    /// Token정보를 Response 할 때 쓰이는 클래스
    @Schema(description = "타입",example = "Bearer")
    private String grantType;
    @Schema(description = "accessToken",example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiYXV0aCI6IlJPTEVfVVNFUiIsImV4cCI6MTY5OTI4MDE1N30.pAWSKZsC2U4HGmH3CLHeU8Q7cu-6sYQFnQNHqE55Vvqa6SwuLSxz49P-m9bHobhOALnBpsH2ZwF-1UjrETIu0g")
    private String accessToken;
    @Schema(description = "refreshToken",example = "eyJhbGciOiJIUzUxMiJ9.eyJleHAiOjE2OTk4ODMxNTd9.W7QWTIj3eWlNl1hWw8sXMNNok_pyean73VtSj_210bABTdBiaNU4xtlBOyUCW-IE-YHlEJ_h3p-sExhVxUC6Sg")
    private String refreshToken;
    @Schema(description = "accessTokenExpiresIn",example = "1699280157365")
    private Long accessTokenExpiresIn;
}
