package com.example.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
//Optional<T> 클래스는 Integer나 Double 클래스처럼 'T'타입의 객체를 포장해 주는 래퍼 클래스(Wrapper class). null이 올 수 있는 값을 감싸는 Wrapper 클래스
//따라서 Optional 인스턴스는 모든 타입의 참조 변수를 저장할 수 있음,
public interface UserRepository extends JpaRepository<User,Long> {//User의 CRUD

    Optional<User> findByEmail(String email);
}
