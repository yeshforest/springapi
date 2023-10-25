package com.example.apidemo.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="POST 예제 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("/api") // 이곳으로 들어오는 API주소를 mapping, /api로  받겠다
public class PostController {
    @Operation(summary = "post 요청 test",description = "param으로 받은 객체를 그대로 출력합니다.")
    @Parameter(name= "searchParam",description = "출력할 searchParam 객체")
    @PostMapping("/postMethod")
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }
}
