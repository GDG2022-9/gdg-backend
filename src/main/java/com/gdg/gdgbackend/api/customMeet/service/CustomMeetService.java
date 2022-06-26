package com.gdg.gdgbackend.api.customMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.api.customMeet.dto.CustomMeetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CustomMeetService {

    private final BoardRepository boardRepository;
    public CustomMeetDto getCustomMeet(String startDate, String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);

        List<Board> customMeetList = boardRepository.findAllByBoardDateBetween(start, end);

        CustomMeetDto customMeetDto = CustomMeetDto.builder()
                .tripStartDate(start)
                .tripEndDate(end)
                .customMeetList(customMeetList)
                .build();

        return customMeetDto;
    }
}
