package com.example.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void 메인페이지_로딩(){

        //when,
        String body = this.restTemplate.getForObject("/",String.class);//GET메소드를 통해 representation을 조회,representation이란 그 상황에 헤드에 어떤 상태에 따라 달라지는듯.

        //then
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");//body에 포함되어있는지 비교
    }
}
