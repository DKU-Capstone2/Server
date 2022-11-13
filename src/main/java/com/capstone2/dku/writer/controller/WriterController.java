package com.capstone2.dku.writer.controller;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.writer.service.WriterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class WriterController {

    private final WriterService writerService;

    @GetMapping("/writer/list/{type}")
    public ResponseDto returnWriterList(@PathVariable String type) {
        return writerService.returnWriterList(type);
    }

    @GetMapping("/writer/profile/{writer_id}")
    public ResponseDto returnWriterProfile(@PathVariable("writer_id") Long writerId) {
        return writerService.returnWriterProfile(writerId);
    }

    @PutMapping("/writer/{commission_id}/{decide}")
    public ResponseDto decideCommission(@PathVariable("commission_id") Long commissionId, @PathVariable String decide){
        // "decide"는 수락 or 거절을 의미, 수락은 "Y", 거절은 "N"으로 가정하겠습니다.
        // 은유님이 리팩터링 할 때 원하는 값으로 변경 바랍니다.
        return writerService.decideCommission(commissionId, decide);
    }

    @GetMapping("/writer/{commission_id}")
    public ResponseDto inquiryCommission(@PathVariable("commission_id") Long commissionId){
        return writerService.writerCommission(commissionId);
    }
}
