package com.capstone2.dku.commission.controller;

import com.capstone2.dku.commission.service.CommissionService;
import com.capstone2.dku.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommissionController {
    private final CommissionService commissionService;


}
