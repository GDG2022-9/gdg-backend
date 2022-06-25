package com.gdg.gdgbackend.web.main.dto;

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
public class MainDto {

    @ApiModelProperty
    private List<Board> customMeet;

    @ApiModelProperty
    private List<Board> currentMeet;

    public static MainDto of(List<Board> customMeet, List<Board> currentMeet) {
        return MainDto.builder()
                .customMeet(customMeet)
                .currentMeet(currentMeet)
                .build();
    }

}
