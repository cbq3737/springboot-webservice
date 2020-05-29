package com.example.springboot.web;

import com.example.springboot.service.PostsService;
import com.example.springboot.web.dto.PostsResponseDto;
import com.example.springboot.web.dto.PostsSaveRequestDto;
import com.example.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    //등록
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){

        return postsService.save(requestDto);
    }
    //put은 json안에 정보를 모두 교체, patch는 일부분만 교체
    //수정
    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }

    //RequestParam:/id?no=1와 같이 url이 전달될 때 no 파라메터를 받아오게 된다. PathVariable: url에서 각 구분자{id}에 들어오는 값을 처리해야 할 때
    //조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id)//PathVariable:말그대로 URL경로에 변수를 넣어준것.
    {
        return postsService.findById(id);
    }
    //삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }
}
