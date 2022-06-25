package com.gdg.gdgbackend.web.currentMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.web.currentMeet.dto.CurrentMeetDto;
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

        List<Board> currentMeetList = boardRepository.findAllByOrdOrderByBoardDateAsc();
        CurrentMeetDto currentMeetDto = CurrentMeetDto.builder()
                .currentMeetList(currentMeetList)
                .build();

        return currentMeetDto;

    }
}
