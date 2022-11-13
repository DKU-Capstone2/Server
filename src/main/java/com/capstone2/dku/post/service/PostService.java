package com.capstone2.dku.post.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.config.security.JwtAuthenticationProvider;
import com.capstone2.dku.post.domain.Post;
import com.capstone2.dku.post.domain.PostRepository;
import com.capstone2.dku.post.dto.CreatePostRequestDto;
import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Service
public class PostService {

    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ResponseDto createPost(Long userId, CreatePostRequestDto createPostRequestDto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("독자를 찾지 못했습니다."));

        Post post = Post.builder()
                .type(createPostRequestDto.getType())
                .title(createPostRequestDto.getTitle())
                .content(createPostRequestDto.getContent())
                .build();

        post.setUser(user);
        postRepository.save(post);

        return new ResponseDto("SUCCESS", post.getPostId());
    }
}
