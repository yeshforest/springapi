package com.example.apidemo.controller;

import com.example.apidemo.dto.MemberRequestDto;
import com.example.apidemo.dto.MemberResponseDto;
import com.example.apidemo.dto.TokenDto;
import com.example.apidemo.dto.TokenRequestDto;
import com.example.apidemo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스이다.
// 따라서 HttpStatus, HttpHeaders, HttpBody를 포함한다.
@Tag(name = "계정관련 처리",description = "회원가입, 로그인, 토큰 재발급 요청을 처리합니다." )
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Operation(summary = "회원가입",description = "요청이 들어오면 회원가입을 진행하고 유저 이메일을 리턴합니다.")
    @Parameter(name = "memberRequestDto", description = "이메일, 비밀번호, 유저이름으로 이루어진 객체를 받습니다.")
    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.signup(memberRequestDto));
    }

    @Operation(summary = "로그인",description = "요청이 들어오면 로그인을 진행하고 토큰정보를 반환합니다.")
    @Parameter(name = "memberRequestDto", description = "이메일, 비밀번호, 유저이름으로 이루어진 객체를 받습니다.")
    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
        return ResponseEntity.ok(authService.login(memberRequestDto));
    }

    @Operation(summary = "토큰 재발급",description = "요청이 들어오면 토큰재발급을 진행하고 토큰정보를 반환합니다.")
    @Parameter(name = "tokenRequestDto", description = "유저가 가지고있던 accessToken, refreshToken을 받습니다.")
    @PostMapping("/reissue")
    public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
        return ResponseEntity.ok(authService.reissue(tokenRequestDto));
    }
}