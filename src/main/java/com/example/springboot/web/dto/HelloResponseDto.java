package com.example.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//앞으로 모든 응답 DTO(데이터 전송 객체)는 이 DTO패키지에 추가한다.
@Getter//게터 발생
@RequiredArgsConstructor//생성자생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}
