package com.example.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class HelloResponseDtoTest {
    @Test//롬복이 잘 돌아가는지 테스트
    public void 롬복_기능_테스트(){
        //given
        String name ="test";
        int amount =1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); //assertThat:assertj라는 테스트 검증 라이브러리의 검증 메소드검증하고 싶은 메소드를 인자로 받는다.
        assertThat(dto.getAmount()).isEqualTo(amount);//isEqualTo는 assertj의 동등 비교 메소드이다.assertThat에 있는 값과 isEqualTo의 값을 비교해서 같은 때만 성고
    }
}
