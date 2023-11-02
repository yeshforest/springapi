package com.example.apidemo.config;

import com.example.apidemo.jwt.JwtAccessDeniedHandler;
import com.example.apidemo.jwt.JwtAuthenticationEntryPoint;
import com.example.apidemo.jwt.JwtSecurityConfig;
import com.example.apidemo.jwt.TokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final TokenProvider tokenProvider;
  //  private final CorsFilter corsFilter;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCryptPasswordEncoder 설정을 기반으로 비밀번호가 해싱된다.
        // 참고문서 : https://jaykaybaek.tistory.com/28

        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // token방식 사용학 때문에 CSRF 설정 Disable
        http.csrf(CsrfConfigurer::disable)
                //.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

                // exception handling 할 때 우리가 만든 클래스를 추가
                .exceptionHandling(authenticationManager -> authenticationManager
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler))

                // h2콘솔을 위한 설정 추가
                .headers((headerConfig)->
                        headerConfig.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin)
                        )

                // 시큐리티는 기본적으로 세션을 사용
                // 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
                .sessionManagement((configurer -> configurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS)))

                // 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()

                // swagger 관련 요청도 permitAll설정
                        .requestMatchers(new AntPathRequestMatcher("/swagger-ui/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/v3/api-docs/**")).permitAll().

                        anyRequest().authenticated()) // 나머지 API 는 전부 인증 필요

                // JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
                .apply(new JwtSecurityConfig(tokenProvider));

        return http.build();
    }
}