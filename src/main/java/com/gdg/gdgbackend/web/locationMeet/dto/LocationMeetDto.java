package com.gdg.gdgbackend.web.locationMeet.dto;

import com.gdg.gdgbackend.domain.board.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Builder
public class LocationMeetDto {

    private List<String> subCategoryList;

    private int count;

    private List<Board> locationMeetList;

}
