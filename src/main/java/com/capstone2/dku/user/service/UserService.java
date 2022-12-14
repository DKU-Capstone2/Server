package com.capstone2.dku.user.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.config.security.JwtAuthenticationProvider;
import com.capstone2.dku.reader.domain.Reader;
import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.user.domain.UserRepository;
import com.capstone2.dku.user.dto.LoginDto;
import com.capstone2.dku.user.dto.SignInRequestDto;
import com.capstone2.dku.user.dto.SignUpRequestDto;
import com.capstone2.dku.user.dto.TokenDto;
import com.capstone2.dku.writer.domain.Writer;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

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

        ResponseDto verifyResult = verifySignUp(signUpRequestDto);

        if (verifyResult.getResult().equals("FAIL")) {
            return verifyResult;
        }

        if(signUpRequestDto.getRole().equals("w")){
            Writer writer = new Writer(signUpRequestDto.getName(), signUpRequestDto.getEmail(), signUpRequestDto.getPassword(),
                    signUpRequestDto.getPhoneNumber(), signUpRequestDto.getRole(), signUpRequestDto.getType());

            userRepository.save(writer);

            return new ResponseDto("SUCCESS", writer.getId());
        }

        Reader reader = new Reader(signUpRequestDto.getName(), signUpRequestDto.getEmail(), signUpRequestDto.getPassword(),
                signUpRequestDto.getPhoneNumber(), signUpRequestDto.getRole());

        userRepository.save(reader);

        return new ResponseDto("SUCCESS", reader.getId());
    }

    @Transactional
    public ResponseDto signIn(SignInRequestDto signInRequestDto) {

        if (!userRepository.existsByEmail(signInRequestDto.getEmail())) {
            return new ResponseDto("FAIL", "???????????? ?????? ??????????????????.");
        }

        User user = userRepository.findByEmail(signInRequestDto.getEmail());
        if (!passwordEncoder.matches(signInRequestDto.getPassword(), user.getPassword())) {
            return new ResponseDto("FAIL", "??????????????? ???????????????.");
        }
        // ????????? ??? ?????? "AccessToken"??? "RefreshToken"??? "TokenDto"??? ?????? ??????
        TokenDto tokenDto = jwtAuthenticationProvider.createToken(user.getEmail(), user.getRoles());

        // ????????? "RefreshToken"??? "Redis"??? ??????, ????????? ?????? ?????? ??????????????? ??????
        // key ???: "RT:email",
        redisTemplate.opsForValue().set("RT:" + user.getEmail(),
                tokenDto.getRefreshToken(), tokenDto.getRefreshTokenTime(), TimeUnit.MILLISECONDS);

        LoginDto loginDto = new LoginDto();
        loginDto.setUserId(user.getId());
        loginDto.setTokenDto(tokenDto);

        return new ResponseDto("SUCCESS", loginDto);

    }

    @Transactional
    public ResponseDto withdrawal(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("????????? ?????? ???????????????."));

        if (!userRepository.existsByEmail(user.getEmail())) {
            return new ResponseDto("FAIL", "???????????? ?????? ??????????????????.");
        }

        if (!user.getEmail().equals(user.getEmail())) {
            return new ResponseDto("FAIL", "???????????? ?????? ??????????????????.");
        }

        userRepository.delete(user);

        return new ResponseDto("SUCCESS", user.getId());
    }

    private ResponseDto verifySignUp(SignUpRequestDto signUpRequestDto) {

        if (userRepository.existsByEmail(signUpRequestDto.getEmail())) {
            return new ResponseDto("FAIL", "?????? ???????????? ??????????????????.");
        }

        if (!signUpRequestDto.getPassword().equals(signUpRequestDto.getCheckPassword())) {
            return new ResponseDto("FAIL", "???????????? ????????? ??????????????? ?????? ????????????.");
        }

        return new ResponseDto("SUCCESS");
    }
}
