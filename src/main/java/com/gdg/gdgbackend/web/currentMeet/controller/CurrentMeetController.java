package com.gdg.gdgbackend.web.currentMeet.controller;

import com.gdg.gdgbackend.web.currentMeet.dto.CurrentMeetDto;
import com.gdg.gdgbackend.web.currentMeet.service.CurrentMeetService;
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

    @GetMapping("/current")
    public ResponseEntity getCurrent() {

        CurrentMeetDto currentMeetDto = currentMeetService.getCurrentMeet();

        return ResponseEntity.ok(currentMeetDto);
    }
}
