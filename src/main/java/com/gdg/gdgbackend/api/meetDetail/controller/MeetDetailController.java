package com.gdg.gdgbackend.api.meetDetail.controller;

import com.gdg.gdgbackend.api.meetDetail.dto.MeetDetailDto;
import com.gdg.gdgbackend.api.meetDetail.service.MeetDetailService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MeetDetailController {

    private final MeetDetailService meetDetailService;

    @ApiOperation(value = "밋트 정보 상세보기")
    @GetMapping("/{boardId}")
    public ResponseEntity getMeetDetail(@PathVariable Long boardId) {

        MeetDetailDto meetDetailDto = meetDetailService.getMeetDetail(boardId);

        return ResponseEntity.ok(meetDetailDto);

    }
}
