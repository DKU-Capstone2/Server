package com.capstone2.dku.writer.service;

import com.capstone2.dku.ResponseDto;
import com.capstone2.dku.user.domain.UserRepository;
import com.capstone2.dku.writer.domain.Writer;
import com.capstone2.dku.writer.dto.WriterResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WriterService {

    private final UserRepository userRepository;

    public ResponseDto returnWriterList(String type) {

        List<WriterResponseDto> writerResponseDtoList = new ArrayList<>();
        List<Writer> writerList = userRepository.findAllByType(type);

        for (Writer w : writerList) {
            WriterResponseDto writerResponseDto = WriterResponseDto.builder()
                    .id(w.getId())
                    .name(w.getName())
                    .build();

            writerResponseDtoList.add(writerResponseDto);
        }

        return new ResponseDto("SUCCESS", writerResponseDtoList);
    }
}