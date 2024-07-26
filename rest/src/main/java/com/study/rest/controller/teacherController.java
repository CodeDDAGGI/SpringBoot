package com.study.rest.controller;

import com.study.rest.dto.ReqTeacherDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class teacherController {

    @CrossOrigin // 실행되는 웹 페이지가 다른 도메인에서 제공하는 리소스에 접근하려고 할 때 발생하는 보안 기능
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> teacherPost(@RequestBody ReqTeacherDto reqTeacherDto) {
        log.info("teacher : {}" , reqTeacherDto);
        return ResponseEntity.badRequest().body("응답데이터");
    }
}
