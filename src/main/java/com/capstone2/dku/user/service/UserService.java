package com.capstone2.dku.user.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.config.security.JwtAuthenticationProvider;
import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.user.domain.UserRepository;
import com.capstone2.dku.user.dto.LoginDto;
import com.capstone2.dku.user.dto.SignInRequestDto;
import com.capstone2.dku.user.dto.SignUpRequestDto;
import com.capstone2.dku.user.dto.TokenDto;
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

        if (userRepository.existsByEmail(signUpRequestDto.getEmail())) {
            return new ResponseDto("FAIL", "이미 존재하는 이메일입니다.");
        }

        if (!signUpRequestDto.getPassword().equals(signUpRequestDto.getCheckPassword())) {
            return new ResponseDto("FAIL", "입력하신 두개의 비밀번호가 서로 다릅니다.");
        }

        // 위의 두개의 if()문을 더 예쁘게 리팩터링 하는 방법
        // 해당 과정을 메서드로 만들어버리기(?)

        User user = User.builder()
                .name(signUpRequestDto.getName())
                .email(signUpRequestDto.getEmail())
                .password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .phoneNumber(signUpRequestDto.getPhoneNumber())
                .role(signUpRequestDto.getRole())
                .build();

        userRepository.save(user);

        return new ResponseDto("SUCCESS", user.getId());
    }

    @Transactional
    public ResponseDto signIn(SignInRequestDto signInRequestDto) {

        if (!userRepository.existsByEmail(signInRequestDto.getEmail())) {
            return new ResponseDto("FAIL", "존재하지 않는 이메일입니다.");
        }

        User user = userRepository.findByEmail(signInRequestDto.getEmail());
        if (!passwordEncoder.matches(signInRequestDto.getPassword(), user.getPassword())) {
            return new ResponseDto("FAIL", "비밀번호가 틀렸습니다.");
        }
        // 로그인 할 경우 "AccessToken"과 "RefreshToken"을 "TokenDto"에 넣어 반환
        TokenDto tokenDto = jwtAuthenticationProvider.createToken(user.getEmail(), user.getRoles());

        // 생성된 "RefreshToken"를 "Redis"에 저장, 시간이 만료 되면 자동적으로 삭제
        // key 값: "RT:email",
        redisTemplate.opsForValue().set("RT:" + user.getEmail(),
                tokenDto.getRefreshToken(), tokenDto.getRefreshTokenTime(), TimeUnit.MILLISECONDS);

        LoginDto loginDto = new LoginDto();
        loginDto.setUserId(user.getId());
        loginDto.setTokenDto(tokenDto);

        return new ResponseDto("SUCCESS", loginDto);

    }

    @Transactional
    public ResponseDto withdrawal(String email, ServletRequest request) {

        String token = jwtAuthenticationProvider.resolveToken((HttpServletRequest) request);
        User user = (User) userDetailsService.loadUserByUsername(jwtAuthenticationProvider.getUserPk(token));

        if (!userRepository.existsByEmail(email)) {
            return new ResponseDto("FAIL", "존재하지 않는 이메일입니다.");
        }

        if (!email.equals(user.getEmail())) {
            return new ResponseDto("FAIL", "이메일을 다시 확인해주세요.");
        }

        userRepository.delete(user);

        return new ResponseDto("SUCCESS", user.getId());
    }
}
