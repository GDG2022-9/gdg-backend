package com.gdg.gdgbackend.web.registerMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import com.gdg.gdgbackend.domain.category.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class RegisterMeetDto {

    private String boardTitle;

    private LocalDateTime boardDate;

    private String boardLocation;

    private String boardContent;

    private String boardImageName;

    private String boardImageUrl;

    private Integer totalCount;

    private int joinCount;

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
