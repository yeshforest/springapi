package com.example.apidemo.controller;

import com.example.apidemo.dto.MemberRequestDto;
import com.example.apidemo.dto.MemberResponseDto;
import com.example.apidemo.dto.TokenDto;
import com.example.apidemo.dto.TokenRequestDto;
import com.example.apidemo.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스이다.
// 따라서 HttpStatus, HttpHeaders, HttpBody를 포함한다.
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController { // TODO: swagger 관련 어노테이션 추가
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}