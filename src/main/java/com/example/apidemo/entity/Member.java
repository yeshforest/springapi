package com.example.apidemo.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String username;  // 이름

    private String email; // 이메일

    private String password; // 비밀번호

    @Enumerated(EnumType.STRING)
    private Authority authority; // 권한
    @Builder
    public Member(String username, String email, String password, Authority authority) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.authority = authority;
    }
}