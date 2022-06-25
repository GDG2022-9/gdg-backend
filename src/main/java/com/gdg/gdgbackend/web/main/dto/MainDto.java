package com.gdg.gdgbackend.web.main.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Builder
public class MainDto {

    private LocalDateTime tripStartDate;

    private Integer tripDuration;

    private List<Board> customBoardList;

    private List<Board> currentBoardList;

    public static MainDto of(LocalDateTime tripStartDate, Integer tripDuration,
                             List<Board> customBoardList, List<Board> currentBoardList) {
        return MainDto.builder()
                .tripStartDate(tripStartDate)
                .tripDuration(tripDuration)
                .customBoardList(customBoardList)
                .currentBoardList(currentBoardList)
                .build();
    }

}
