package com.example.springboot.web;

import com.example.springboot.config.auth.LoginUser;
import com.example.springboot.config.auth.dto.SessionUser;
import com.example.springboot.service.PostsService;
import com.example.springboot.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    //리스트
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        //SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if (user != null) {
            logger.info(user.getEmail());
            model.addAttribute("name",user.getName()); //키값을 userName으로 주면 이름이 안뜨고 user라는 값만 계속떠서 name으로 바꿔주니 오류 해결
        }
        model.addAttribute("posts", postsService.findAllDesc());

        return "index";
    }

    //게시글 적는곳으로
    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    //게시글 수정하는 페이지로
    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
