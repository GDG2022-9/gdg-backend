package com.gdg.gdgbackend.web.meetDetail.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class MeetDetailDto {

    private String boardTitle;

    private LocalDateTime boardDate;

    private String boardLocation;

    private String boardContent;

    private String boardImageName;

    private String boardImageUrl;

    private Integer totalCount;

    private int joinCount;
}
