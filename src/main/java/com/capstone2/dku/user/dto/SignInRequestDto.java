package com.capstone2.dku.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
public class SignInRequestDto {

    @Email
    private String email;

    @Size(min=4,max=15, message = "4~15 글자의 패스워드를 입력해주세요")
    private String password;
}
