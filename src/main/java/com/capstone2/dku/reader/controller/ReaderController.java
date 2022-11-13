package com.capstone2.dku.reader.controller;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.reader.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/reader/profile/{id}")
    public ResponseDto returnWriterProfile(@PathVariable Long id){
        return readerService.returnReaderProfile(id);
    }
}
