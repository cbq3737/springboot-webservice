package com.example.springboot.web.dto;

import com.example.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder// 자동 호출,builder란 spring의 factory에 등록이 되어 어노테이션으로써 request가 들어오면 beans에 등록되어있다보니 자동 호출을 해준다. 하지만 setter가 없다보니 request로 안받으면 생성이 안된다.
    public PostsSaveRequestDto(String title,String content,String author)
    {
        this.title= title;
        this.content= content;
        this.author=author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
