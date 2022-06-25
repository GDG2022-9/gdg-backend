package com.gdg.gdgbackend.web.main.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.web.main.dto.MainDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MainService {

    private final BoardRepository boardRepository;

    public MainDto getMain(String startDate, String endDate) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime start = LocalDateTime.parse(startDate, formatter);
        LocalDateTime end = LocalDateTime.parse(endDate, formatter);

        // 맞춤 밋트 & 실시간 밋트
        List<Board> customBoardList = boardRepository.findAllByBoardDateBetween(start, end);
        List<Board> currentBoardList = boardRepository.findAllByOrderByBoardDateAsc();

        List<Board> customMeet = new ArrayList<>();
        List<Board> currentMeet = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            customMeet.add(customBoardList.get(i));
            currentMeet.add(currentBoardList.get(i));
        }

        MainDto mainDto = MainDto.of(customMeet, currentMeet);

        return mainDto;

    }
}
