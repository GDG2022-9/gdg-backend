package com.gdg.gdgbackend.web.meetDetail.controller;

import com.gdg.gdgbackend.web.meetDetail.dto.MeetDetailDto;
import com.gdg.gdgbackend.web.meetDetail.service.MeetDetailService;
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

    @GetMapping("/{boardId}")
    public ResponseEntity getMeetDetail(@PathVariable Long boardId) {

        MeetDetailDto meetDetailDto = meetDetailService.getMeetDetail(boardId);

        return ResponseEntity.ok(meetDetailDto);

    }
}
