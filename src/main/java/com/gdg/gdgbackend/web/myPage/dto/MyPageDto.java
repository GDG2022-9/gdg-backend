package com.gdg.gdgbackend.web.myPage.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@Builder
public class MyPageDto {

    private String userName;

    private LocalDateTime startDate;

    private int duration;

}
