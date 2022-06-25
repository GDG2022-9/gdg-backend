package com.gdg.gdgbackend.web.registerMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.category.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Builder
@ApiModel
public class RegisterMeetDto {

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

    @ApiModelProperty
    private Category category;

    public Board toEntity() {
        return Board.builder()
                .boardTitle(boardTitle)
                .boardDate(boardDate)
                .boardLocation(boardLocation)
                .boardContent(boardContent)
                .boardImageName(boardImageName)
                .boardImageUrl(boardImageUrl)
                .totalCount(totalCount)
                .joinCount(joinCount)
                .category(category)
                .build();
    }
}
