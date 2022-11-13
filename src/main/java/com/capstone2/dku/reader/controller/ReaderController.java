package com.capstone2.dku.reader.controller;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.reader.dto.CommissionRequestDto;
import com.capstone2.dku.reader.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ReaderController {

    private final ReaderService readerService;

    @GetMapping("/reader/profile/{id}")
    public ResponseDto returnWriterProfile(@PathVariable Long id){
        return readerService.returnReaderProfile(id);
    }

    @PostMapping("/commission/{writer_id}")
    public ResponseDto applyCommission(@PathVariable("writer_id") Long writerId, @RequestBody CommissionRequestDto commissionRequestDto){
        return readerService.applyCommission(writerId, commissionRequestDto);
    }

    @GetMapping("reader/{commission_id}")
    public ResponseDto inquiryCommission(@PathVariable("commission_id") Long commissionId){
        return readerService.writerCommission(commissionId);
    }
}
