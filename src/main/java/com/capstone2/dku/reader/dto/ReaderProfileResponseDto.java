package com.capstone2.dku.reader.dto;

import lombok.Builder;

public class ReaderProfileResponseDto {

    private String name;
    private String email;
    private String phoneNumber;

    @Builder
    public ReaderProfileResponseDto(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
