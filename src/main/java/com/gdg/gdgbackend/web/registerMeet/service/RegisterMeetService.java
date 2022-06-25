package com.gdg.gdgbackend.web.registerMeet.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.web.registerMeet.dto.RegisterMeetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RegisterMeetService {

    private final BoardRepository boardRepository;

    @Transactional
    public void registerMeet(RegisterMeetDto registerMeetDto) {
        Board board = registerMeetDto.toEntity();
        boardRepository.save(board);
    }
}
