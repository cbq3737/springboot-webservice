package com.example.springboot.domain.posts;

import com.example.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//mybatis의 dao와 xml에서일어났던 xml에 쿼리담고 클래스는 오로지 쿼리의 결과만 담던 일들이 모두 도메인 클래스라고 불린는곳에서 해결된다.
//필드값 변경 메소드를 만들때 인스턴스값을 주지않는다.
@Getter
@NoArgsConstructor
@Entity//Posts.java이므로 posts table일듯, 이런식으로 매칭해준다.Entity는 DB에 이런 테이블이 있다고 알려주는 역할.
public class Posts extends BaseTimeEntity {

    @Id//PrimaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GenerationType.IDENTITY덕분에 Auto_increment
    private Long id;

    @Column (length =500 , nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder//생성자 상단에 포함된 필드만 빌더에 포함
    public Posts(String title,String content,String author)
    {
        this.title=title;
        this.author = author;
        this.content = content;
    }
    public void update(String title,String content)
    {
        this.title=title;
        this.content=content;
    }
}
