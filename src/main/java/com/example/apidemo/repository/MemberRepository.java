package com.example.apidemo.repository;

import com.example.apidemo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository  extends JpaRepository<Member,Long> {
    Optional<Member> findByEmail(String email);
    boolean existsByEmail(String email); // 이메일 로그인 중복가입 방지, 이메일 존재여부 파악
}
