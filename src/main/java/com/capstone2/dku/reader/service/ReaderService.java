package com.capstone2.dku.reader.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.commission.domain.CommissionEntity;
import com.capstone2.dku.commission.domain.CommissionRepository;
import com.capstone2.dku.exception.domain.WriterNotFoundException;
import com.capstone2.dku.reader.domain.Reader;
import com.capstone2.dku.reader.dto.CommissionRequestDto;
import com.capstone2.dku.reader.dto.ReaderProfileResponseDto;
import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.user.domain.UserRepository;
import com.capstone2.dku.writer.domain.Writer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReaderService {

    private final UserRepository userRepository;
    private final CommissionRepository commissionRepository;

    public ResponseDto returnReaderProfile(Long id) {

        // 아래의 예외처리는 은유님이 직접 하시면 될 것 같습니다.
        // 일반 유저는 독자라고 가정을 하고 로직을 만들었습니다.
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("독자를 찾지 못했습니다."));

        ReaderProfileResponseDto readerProfileResponseDto = ReaderProfileResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();

        return new ResponseDto("SUCCESS", readerProfileResponseDto);
    }

    public ResponseDto applyCommission(Long writerId, CommissionRequestDto commissionRequestDto) {

        User user = userRepository.findById(writerId)
                .orElseThrow(() -> new IllegalArgumentException("독자를 찾지 못했습니다."));

        Writer writer = userRepository.findByIdAndRole(writerId,"w")
                .orElseThrow(() -> new WriterNotFoundException());

        CommissionEntity commissionEntity = CommissionEntity.builder()
                .reader((Reader)user)
                .writer(writer)
                .commissionState("apply")
                .commissionContent(commissionRequestDto.getCommissionContent())
                .build();

        commissionRepository.save(commissionEntity);

        return new ResponseDto("SUCCESS",commissionEntity.getCommissionId());
    }

    public ResponseDto writerCommission(Long commissionId) {

        CommissionEntity commissionEntity = commissionRepository.findById(commissionId)
                .orElseThrow(() -> new IllegalArgumentException("해당 커미션은 존재하지 않습니다."));

        // 커미션의 상태 반환
        return new ResponseDto("SUCCESS", commissionEntity.getCommissionState());
    }
}
