package com.capstone2.dku.writer.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class WriterResponseDto {

    private Long id;
    private String name;

    @Builder
    public WriterResponseDto(Long id, String name){
        this.id = id;
        this.name = name;
    }
}