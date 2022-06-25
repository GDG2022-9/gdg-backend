package com.gdg.gdgbackend.web.meetDetail.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
@ApiModel
public class MeetDetailDto {

    @ApiModelProperty
    private String boardTitle;

    @ApiModelProperty
    private LocalDateTime boardDate;

    @ApiModelProperty
    private String boardLocation;

    @ApiModelProperty
    private String boardContent;

    @ApiModelProperty
    private String boardImageName;

    @ApiModelProperty
    private String boardImageUrl;

    @ApiModelProperty
    private Integer totalCount;

    @ApiModelProperty
    private int joinCount;
}
