package com.example.apidemo.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * swagger 접속 URL  http://localhost:8080/swagger-ui/index.html
 */

// Configuration 이란 해당 클래스는 xml 설정을 대체하는 스프링 설정 클래스가 된다. (Java Config)
@Configuration
public class SwaggerConfig {
    // Bean이란 스프링 IoC 컨테이너에 등록된 객체를 말한다. Bean도 일종의 POJO(특정 기술에 종속되어 있지 않은 순수 자바 객체) 이다.
    // 크게 다를게 없다. 그런데 이때 스프링 IoC 컨테이너에 등록되어야지만,
    // 스프링이 돌아가는데 있어서 해당 객체들을 사용 할 수 있다.
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes(
                        "bearer-key",
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
                ))
                .info(apiInfo());
    }

    private Info apiInfo() {
        return new Info()
                .title("Swagger UI와 JWT test")
                .description("Springdoc을 사용한 Swagger UI 테스트와 JWT 테스트를 위한 로그인,회원가입")
                .version("1.0.1");
    }
}
