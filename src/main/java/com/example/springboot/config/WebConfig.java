package com.example.springboot.config;

import com.example.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
//대부분 웹 어플리케이션에서 사용자들이 로그인 인증 후 서버에서 세션을 생성하고 발급을 해주게 됩니다.
// 그때마다 컨트롤러에서 세션정보를 요구하는 특정 메소드를 수행하게 되면 이 코드처럼 중복적인 코드를 작성해야 되는 불필요한 상황이 발생하게 됩니다
// public String index(Model model, HttpSession httpSession){
//        // session 값을 추출해야 하는 코드
//        User user = (User) httpSession.getAttribute("user");
//이러한 불필요한 코드를 작성하는 상황을 해결하기 위해서 HandlerMethodArgumentResolver 인터페이스를 사용합니다.
@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers)//HandlerMethodArgumentResolver는 컨트롤러 메소드에서 특정 조건에 맞는 파라미터가 있을 때 원하는 값을 바인딩 해주는 인터페이스
    {
        argumentResolvers.add(loginUserArgumentResolver);
    }
//스프링에서는 Controller에서 @RequestBody 어노테이션을 사용해 Request의 Body 값을 받아올 때, @PathVariable 어노테이션을 사용해 Request의 Path Parameter 값을 받아올 때 이 HandlerMethodArgumentResolver를 사용해서 값을 받아옵니다.
}
