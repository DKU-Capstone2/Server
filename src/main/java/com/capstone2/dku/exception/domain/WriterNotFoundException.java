package com.capstone2.dku.exception.domain;

public class WriterNotFoundException extends RuntimeException{

    // log Message
    private static final String MESSAGE = "해당 작가는 존재하지 않는 작가입니다.";

    public WriterNotFoundException() {
        super(MESSAGE);
    }
}
