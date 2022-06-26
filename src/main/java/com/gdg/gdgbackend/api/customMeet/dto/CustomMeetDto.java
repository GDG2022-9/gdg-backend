package com.gdg.gdgbackend.api.customMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@Builder
@ApiModel
public class CustomMeetDto {

    @ApiModelProperty
    private LocalDateTime tripStartDate;

    @ApiModelProperty
    private LocalDateTime tripEndDate;

    @ApiModelProperty
    private List<Board> customMeetList;
}
