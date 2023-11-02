package com.example.apidemo.dto;

import com.example.apidemo.entity.Authority;
import com.example.apidemo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

// DTO는 계층간 데이터 교환을 위한 객체로, 로직을 가지지 않는 순수한 데이터 객체이다.
// 일반적으로 DTO는 순수한 데이터 객체로써 속성과 그 속성에 접근하기 위한 getter, setter메소드만 가진 클래스이다.
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequestDto {
    /// 로그인/회원가입을 요청할 때 쓰이는 Dto
    private String email;
    private String password;
    private String username;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .authority(Authority.ROLE_USER)
                .username(username)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(email, password);
    }
}