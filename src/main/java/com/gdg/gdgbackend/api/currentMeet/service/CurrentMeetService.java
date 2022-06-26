package com.gdg.gdgbackend.api.currentMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.api.currentMeet.dto.CurrentMeetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CurrentMeetService {

    private final BoardRepository boardRepository;

    public CurrentMeetDto getCurrentMeet() {

        List<Board> currentMeetList = boardRepository.findAllByOrderByBoardDateAsc();
        CurrentMeetDto currentMeetDto = CurrentMeetDto.builder()
                .currentMeetList(currentMeetList)
                .build();

        return currentMeetDto;

    }
}
