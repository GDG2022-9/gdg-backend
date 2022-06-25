package com.gdg.gdgbackend.web.registerMeet.controller;

import com.gdg.gdgbackend.web.registerMeet.dto.RegisterMeetDto;
import com.gdg.gdgbackend.web.registerMeet.service.RegisterMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RegisterMeetController {

    private final RegisterMeetService registerMeetService;

    @PostMapping("/new-meet")
    public ResponseEntity registerMeet(@RequestBody RegisterMeetDto registerMeetDto) {

        registerMeetService.registerMeet(registerMeetDto);

        return ResponseEntity.ok().body("register success");
    }
}
