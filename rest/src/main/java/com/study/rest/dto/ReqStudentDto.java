package com.study.rest.dto;

import lombok.Data;
//import lombok.ToString;

// DTO Data Transfer Object 
// 어플리케이션의 여러 계층간에 데이터를 전달할 때 사용되는 객체
// 두개가 연결될때 통신의 인터페이스라고 함
// @ToString // 객체 안의 문자열 접근
// 프론트앤드에서 보낼때 양식 맞춰서 보내줘야댐
@Data
public class ReqStudentDto {
    private String schoolName;
    private String department;
    private int grade;
    private String name;
}
