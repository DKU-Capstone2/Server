package com.capstone2.dku.writer.controller;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.writer.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WriterController {

    private final WriterService writerService;

    @GetMapping("/writer/list/{type}")
    public ResponseDto returnWriterList(@PathVariable String type) {
        return writerService.returnWriterList(type);
    }

    @GetMapping("/writer/profile/{id}")
    public ResponseDto returnWriterProfile(@PathVariable Long id){
        return writerService.returnWriterProfile(id);
    }

}
