package com.capstone2.dku.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class SignUpRequestDto {

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @Email(message = "이메일 형식을 확인해주세요")
    private String email;

    @Size(min=4,max=15, message = "4~15 글자의 패스워드를 입력해주세요")
    private String password;

    @Builder
    public SignUpRequestDto(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }
}