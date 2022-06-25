package com.gdg.gdgbackend.web.meetDetail.service;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.board.repository.BoardRepository;
import com.gdg.gdgbackend.global.error.exception.EntityNotFoundException;
import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import com.gdg.gdgbackend.web.meetDetail.dto.MeetDetailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MeetDetailService {

    private final BoardRepository boardRepository;

    public MeetDetailDto getMeetDetail(Long boardId) {

        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEET_NOT_EXIST));

        MeetDetailDto meetDetailDto = MeetDetailDto.builder()
                .boardTitle(board.getBoardTitle())
                .boardDate(board.getBoardDate())
                .boardLocation(board.getBoardLocation())
                .boardContent(board.getBoardContent())
                .boardImageName(board.getBoardImageName())
                .boardImageUrl(board.getBoardImageUrl())
                .totalCount(board.getTotalCount())
                .joinCount(board.getJoinCount())
                .build();


        return meetDetailDto;
    }
}
