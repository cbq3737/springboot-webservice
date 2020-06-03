package com.example.springboot.config.auth;

import com.example.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter { //소셜 로그인 설정 코드

    private final CustomOAuth2UserService customOAuth2UserService;///RequiredArgsConstructor인한 생성자 생성

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        http.csrf().disable()
                .headers().frameOptions().disable()//h2-console을 사용하기 위한 option disable
                .and()
                .authorizeRequests()//authorize: 승인하다.
                .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**")//권한 관리대상,안에 인자 URL들은 permitAll()에 의해 전체 열람 권한
                .permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())//이 URL은 USER권한 가진 사람만
                .anyRequest().authenticated()//설정된 값들 이외 나머지 URL들을 나타낸다.authenticated땜에 나머지 URL들은 모두 인증된 사용자에게만 허용
                .and()
                .logout().logoutSuccessUrl("/")//로그아웃 성공한다면 / 로
                .and()
                    .oauth2Login()//oauth2 로그인에대한 진입점
                .userInfoEndpoint()//로그인 성공ㅇ후 사용자 정보 가져올 때
                .userService(customOAuth2UserService);//로그인 성공시 후속 할 일을 진행할 UserService의 인터페이스에 값을 주므로 후에 할 일을 적음.
    }

}
