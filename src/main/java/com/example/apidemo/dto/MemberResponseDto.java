package com.example.apidemo.dto;

import com.example.apidemo.entity.Member;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "회원가입 응답 DTO")
public class MemberResponseDto {
    @Schema(description = "이메일",example = "love@pipebuilder.com")
    private String email;

    public static MemberResponseDto of(Member member) {
        return new MemberResponseDto(member.getEmail());
    }
}