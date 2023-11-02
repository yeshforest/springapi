package com.example.apidemo.dto;

import lombok.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDto {
    /// Token정보를 Response 할 때 쓰이는 클래스

    private String grantType;
    private String accessToken;
    private String refreshToken;
    private Long accessTokenExpiresIn;
}
