package com.example.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role { //사용자의 권한 관리

    GUEST("ROLE_GUEST","손님"),//security에서 권한코드는 ROLE_ 이 앞에있어야한다.
    USER("ROLE_USER","일반사용자");

    private final String key;
    private final String title;

}
