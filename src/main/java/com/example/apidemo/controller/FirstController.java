package com.example.apidemo.controller;

import com.example.apidemo.service.FirstService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Tag(name = "Get 예제 API", description = "Swagger 테스트용 API")
@RestController // @Controller와 @ResponseBody가 합쳐진 어노테이션으로 주 용도는 Json 형태로 객체 데이터를 반환하는 것이다.
@RequiredArgsConstructor // Lombok의 기능으로 final이 붙거나 @NotNull 이 붙은 필드의 생성자를 자동 생성해주는 Lombok 어노테이션이다.
public class FirstController {

    private final FirstService firstService;
    @Operation(summary = "get 요청 test",description = "/first로 get요청이 들어오면 의미없는 json data를 응답합니다.")
    @GetMapping("/first") // API의 메서드 지정으로 GET 방식의 API를 지정하는 방식이다.
    public Map<String, Object> firstController() {
        return firstService.getFirstData();
    }


}
