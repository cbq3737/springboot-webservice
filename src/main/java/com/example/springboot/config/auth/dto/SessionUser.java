package com.example.springboot.config.auth.dto;

import com.example.springboot.domain.user.User;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@ToString
public class SessionUser implements Serializable { //일정시간 동안 같은사용자로부터 들어오는 일련의 요구를 하나의 상태로 본다,그상태를 일정하게 유지시키는 기술
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name =  user.getName();
        this.email= user.getEmail();
        this.picture= user.getPicture();
    }
}
