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

    @Size(min=4,max=15, message = "4~15 글자의 패스워드를 입력해주세요")
    private String checkPassword;

    @NotBlank(message = "작가, 독자를 선택해주세요")
    private String role;

    @Size(min=11, max=13, message = "핸드폰 번호를 입력해주세요")
    private String phoneNumber;


}
