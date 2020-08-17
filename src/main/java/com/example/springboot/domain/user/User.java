package com.example.springboot.domain.user;

import com.example.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity

public class User extends BaseTimeEntity { //회원정보 Entity,즉 세션을 위한 테이블

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)//JPA로 데이터베이스 저장할 때, Enum값을 어떤 형태로 저장할지를 결정한다.
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String name,String email,String picture,Role role)
    {
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.role=role;
    }

    public User update(String name,String picture){
        this.name = name;
        this.picture = picture;

        return this;
    }

    public String getRoleKey()
    {
        return this.role.getKey();
    }
}
