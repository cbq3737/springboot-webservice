package com.example.springboot.web;

import com.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //JSON을 반환
public class HelloController {
    //@RequestMapping(value="/hello",method=RequestMethod.GET)를 줄인것.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount){

        return new HelloResponseDto(name,amount);
    }
}
