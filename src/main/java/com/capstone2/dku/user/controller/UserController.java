package com.capstone2.dku.user.controller;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.user.dto.SignInRequestDto;
import com.capstone2.dku.user.dto.SignUpRequestDto;
import com.capstone2.dku.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signUp")
    public ResponseDto signUp(@Valid @RequestBody SignUpRequestDto signUpRequestDto){
        return userService.signUp(signUpRequestDto);
    }

    @PostMapping("/user/signIn")
    public ResponseDto signIn(@Valid @RequestBody SignInRequestDto signInRequestDto){
        return userService.signIn(signInRequestDto);
    }

    @DeleteMapping("/user/withdrawal/{email}")
    public ResponseDto Withdrawal(@PathVariable String email, ServletRequest request){
        return userService.withdrawal(email, request);
    }



}
