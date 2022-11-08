package com.capstone2.dku.writer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WriterProfileResponseDto {

    private String name;
    private String email;
    private String phoneNumber;

    @Builder
    public WriterProfileResponseDto(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
