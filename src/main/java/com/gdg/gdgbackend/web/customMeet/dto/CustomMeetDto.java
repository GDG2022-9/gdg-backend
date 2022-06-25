package com.gdg.gdgbackend.web.customMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Builder
public class CustomMeetDto {

    private LocalDateTime tripStartDate;

    private Integer tripDuration;

    private List<Board> customMeetList;
}
