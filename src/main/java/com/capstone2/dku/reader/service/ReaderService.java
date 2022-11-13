package com.capstone2.dku.reader.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.reader.dto.ReaderProfileResponseDto;
import com.capstone2.dku.user.domain.User;
import com.capstone2.dku.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReaderService {

    private final UserRepository userRepository;

    public ResponseDto returnReaderProfile(Long id) {

        // 아래의 예외처리는 은유님이 직접 하시면 될 것 같습니다.
        // 일반 유저는 독자라고 가정을 하고 로직을 만들었습니다.
        User user = userRepository.findByIdAndRole(id,"r")
                .orElseThrow(() -> new IllegalArgumentException("독자를 찾지 못했습니다."));

        ReaderProfileResponseDto readerProfileResponseDto = ReaderProfileResponseDto.builder()
                .name(user.getName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .build();

        return new ResponseDto("SUCCESS", readerProfileResponseDto);
    }
}
