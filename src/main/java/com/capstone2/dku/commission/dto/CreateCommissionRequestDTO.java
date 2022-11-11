package com.capstone2.dku.commission.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CreateCommissionRequestDTO {

    @NotBlank(message = "커미션 신청 제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "커미션 신청 내용을 입력해주세요.")
    private String content;

}
