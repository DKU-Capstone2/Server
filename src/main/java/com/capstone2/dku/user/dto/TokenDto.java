package com.capstone2.dku.user.dto;

import lombok.Data;

@Data
public class TokenDto {
    private String accessToken;
    private String refreshToken;
    private Long accessTokenTime;
    private Long refreshTokenTime;
}

