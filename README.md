# SpringTest

## 포함 예제

* spring security + jwt
* get, post요청
* swagger

## 환경 및 버전
* spring Boot  : v3.1.4
* Java         : v17   
* h2           : v1.4.200 <br>

[h2 다운로드 링크](https://www.h2database.com/html/download-archive.html)

## 테스트 방법
### 로컬 환경에서 실행 시 
1. h2 db 실행 <br>
   실행방법 : 터미널로 h2 설치 경로로 들어가 bin 폴더를 연다. 해당 경로에서 ./h2.sh를 입력한다.
   아래 주소로 들어가면 h2 database가 실행된다.<br>
   http://localhost:8082/ 
```text
/// 터미널 예시
hr.r@nohyelim-ui-MacBookAir bin % pwd    
/Users/hr.r/Documents/spring/h2/bin
hr.r@nohyelim-ui-MacBookAir bin % ./h2.sh
```   
![스크린샷 2023-11-06 오후 10 36 04](https://github.com/yeshforest/springapi/assets/88522164/63702bb7-4b39-44f2-943a-0e45f83c5c01)

2. spring boot 실행
3. 테스트는 Swagger UI참고
Swagger-UI Url : http://localhost:8080/swagger-ui/index.html 

## 연관 프로젝트
* Shampoo
