package com.example.springboot.service;

import com.example.springboot.domain.posts.Posts;
import com.example.springboot.domain.posts.PostsRepository;
import com.example.springboot.web.dto.PostsListResponseDto;
import com.example.springboot.web.dto.PostsResponseDto;
import com.example.springboot.web.dto.PostsSaveRequestDto;
import com.example.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto)
    {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional//다른 예제보면 어노테이션을 사용하지 않았을때, Entity의 매니저객체생성, Entitiy의 트랜잭션생성 후 begin안에서 데이터 처리 하고 커밋이나 롤백한다.
    public Long update(Long id,PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다.id="+id));

        posts.update(requestDto.getTitle(),requestDto.getContent());//다른 update처럼 값을 바꾼뒤 저장하는 쿼리를 주지않아도 transaction안에서 시행되면 자동 업데이트된다.
        return id;
    }
    @Transactional(readOnly = true)
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //stream:자바의 자료구조를 다루게 하고,람다를 사용하게 함.배열의 원소를 가공하는데 map을 사용,map은 요소들을 특정조건에 해당하는 값으로 변환해줌.collect를 이용하여 결과를 리턴받는다.
    public List<PostsListResponseDto> findAllDesc(){ //posts이름으로 쿼리로 인해 list에 Posts형태로 넘어온 Post의 stream을 PostsListResponseDto로 변환 후 List화
        return postsRepository.findAllDesc().stream().map(posts->new PostsListResponseDto(posts)).collect(Collectors.toList());
    }
    @Transactional//여기에 (readOnly = true) 있으면 수정이 안됨.
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }
}
