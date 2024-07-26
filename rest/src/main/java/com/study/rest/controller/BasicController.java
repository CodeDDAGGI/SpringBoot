package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


// REST API
@Slf4j // 코드에서 로그를 쉽게 기록
@RestController // 데이터 요청만하고 데이터만 응답 controller, responsebody가 포함되있음
public class BasicController {

    @Autowired
    private ProductService productService;
    /*
    * REST API
    * 데이터 통신을 위한 HTTP 요청 방식
    * HTTP (프로토콜)을 조금 더 잘 쓰기 위해서 정의된 개념
    * 1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자. (규정같은거라서 의도대로 사용되게 작성을 해줘야한다)
    *  - 데이터 추가(등록)은 POST 요청으로 하자. 그리고 POST요청은 JSON 데이터로 요청하자
    *  - 데이터 조회는 GET 요청으로 하자,
    *       그리고 GET요청은 QueryString(params)으로 요청하자.
    *       예) 주소?key1=value1&key2=value2
    *  - 데이터 수정은 PUT, PATCH 요청으로 하자, JSON으로 요청하자.
    *       PUT 요청과 PATCH 요청의 차이점
    *       PUT 요청 : 공백 또는 NULL인 데이터도 수정을 함
    *       PATCH 요청 : 공백 또는 NULL인 데이터는 수정을 하지 않음. (비밀번호같은경우는 NULL일수가 없음)
    *  - 데이터 삭제는 DELETE 요청으로 하자. params로 요청하자
    *  
    * 2. 주소(URL) 요청 메세지(Resource) 자원 작성법
    *  - URL은 가능한 동사를 사용하지 않는다.
    *  - 계층 구조로 작성한다.
    *       예) /집/주방/가스레인지, /식당/주방/가스레인지
    *  - 요청 메소드 마다 작성하는 방법이 다르다.
    *       상품 등록(POST) /product
    *       상품 하나(단건) 조회(GET) /product/1(id / key) 1번상품 조회 
    *       상품 여러개(다건) 조회(GET) /products(전체), /products?page=1&count=30(한페이지에 30개씩)
    *       상품 수정(PUT) /product/1(id , key)
    *       상품 삭제(DELETE) /product/1(id , key)
    * 3. 주소는 가능한 대문자를 사용하지 않는다
    *
    */
    @CrossOrigin
    @PostMapping("/basic/student") // 프론트엔드에서 객체를 전달 받아야함 (HTTP POST 요청을 처리하기 위한 메서드 - Spring MVC 컨트롤러)
    // 응답 데이터의 타입
    public ResponseEntity<?> basicPost(@RequestBody ReqStudentDto reqStudentDto) {// JSON으로 객체(데이터)가 들어오고 요청이라 자바 객체로 변환해줌 @RequestBody , Params
        // @RequestBody : HTTP 요청의 본문(body)을 메서드의 매개변수로 변환 , JSON, XML 등의 형식으로 요청 본문을 처리
        log.info("Student : {}" , reqStudentDto); // 문자열 출력 ( {} 안으로 reqStudentDto 값이 들어감 )
        return ResponseEntity.badRequest().body("응답데이터"); // ok -> 상태 코드 200 body : 응답데이터 작성
        // 리턴은 객체 형태로 반환해야댐
        // log.info 사용하면 오류정보를 알수있음(기록이남음)
    }

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
        return ResponseEntity.ok().body(productService.registerProduct(register));
    }

    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi() {
        return ResponseEntity.ok().body(productService.getSizeListAll());
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi() {
        return ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> responseSizeApi(@RequestBody ReqRegisterSizeDto reqRegisterSizeDto) {
        log.info("{}", reqRegisterSizeDto);
        return ResponseEntity.ok().body(productService.registerSize(reqRegisterSizeDto));
    }

    @CrossOrigin
    @PostMapping("/api/v1/color")
    public ResponseEntity<?> responseSizeApi(@RequestBody ReqRegisterColorDto reqRegisterColorDto) {
        log.info("{}", reqRegisterColorDto);
        return ResponseEntity.ok().body(productService.registerColor(reqRegisterColorDto));
    }

//    @CrossOrigin
//    @PostMapping("/basic/teacher")
//    public ResponseEntity<?> teacherPost(@RequestBody ReqTeacherDto reqTeacherDto) {
//        log.info("teacher : {}" , reqTeacherDto);
//        return ResponseEntity.badRequest().body("응답데이터");
//    }
//    서버 재시작 ctrl + F5
}
