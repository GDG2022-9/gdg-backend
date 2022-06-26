package com.gdg.gdgbackend.api.currentMeet.controller;

import com.gdg.gdgbackend.api.currentMeet.dto.CurrentMeetDto;
import com.gdg.gdgbackend.api.currentMeet.service.CurrentMeetService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CurrentMeetController {

    private final CurrentMeetService currentMeetService;

    @ApiOperation(value = "실시간 밋트 정보 가져오기")
    @GetMapping("/current")
    public ResponseEntity getCurrent() {

        CurrentMeetDto currentMeetDto = currentMeetService.getCurrentMeet();

        return ResponseEntity.ok(currentMeetDto);
    }
}
