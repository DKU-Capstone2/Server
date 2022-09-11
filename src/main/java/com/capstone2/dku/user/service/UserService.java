package com.capstone2.dku.user.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.config.security.JwtAuthenticationProvider;
import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.user.domain.UserRepository;
import com.capstone2.dku.user.dto.SignUpRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final JwtAuthenticationProvider jwtAuthenticationProvider;
    private final PasswordEncoder passwordEncoder;
    private final RedisTemplate redisTemplate;
    private final UserDetailsService userDetailsService;

    @Transactional
    public ResponseDto signUp(SignUpRequestDto signUpRequestDto) {

        User user = User.builder()
                .name(signUpRequestDto.getName())
                .email(signUpRequestDto.getEmail())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .build();

        userRepository.save(user);

        return new ResponseDto("SUCCESS", user.getId());
    }
}
