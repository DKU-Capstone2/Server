package com.capstone2.dku.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public class ExceptionResponseDto {
    private int code;
    private String message;
    private String exceptionContent;

    @Builder
    public ExceptionResponseDto(int code, String message, String exceptionContent){
        this.code = code;
        this.message = message;
        this.exceptionContent = exceptionContent;
    }
}
