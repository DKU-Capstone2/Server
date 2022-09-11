package com.capstone2.dku.user.dto;

import lombok.Data;

@Data
public class LoginDto {
    private Long userId;
    private TokenDto tokenDto;
}
