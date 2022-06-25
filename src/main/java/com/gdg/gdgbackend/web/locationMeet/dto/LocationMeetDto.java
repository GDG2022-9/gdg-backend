package com.gdg.gdgbackend.web.locationMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
@ApiModel
public class LocationMeetDto {

    @ApiModelProperty
    private List<String> subCategoryList;

    @ApiModelProperty
    private int count;

    @ApiModelProperty
    private List<Board> locationMeetList;

}
