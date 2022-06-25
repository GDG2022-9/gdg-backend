package com.gdg.gdgbackend.web.currentMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
@ApiModel
public class CurrentMeetDto {

    private List<Board> currentMeetList;
}
