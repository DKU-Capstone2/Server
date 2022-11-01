package com.capstone2.dku.post.controller;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.post.dto.CreatePostRequestDto;
import com.capstone2.dku.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/post/create")
    public ResponseDto createPost(ServletRequest request, @Valid @RequestBody CreatePostRequestDto createPostRequestDto) {
        return postService.createPost(request, createPostRequestDto);
    }

}
