package com.gdg.gdgbackend.api.registerMeet.controller;

import com.gdg.gdgbackend.api.registerMeet.dto.RegisterMeetDto;
import com.gdg.gdgbackend.api.registerMeet.service.RegisterMeetService;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "밋트 정보 등록하기")
    public ResponseEntity registerMeet(@RequestBody RegisterMeetDto registerMeetDto) {

        registerMeetService.registerMeet(registerMeetDto);

        return ResponseEntity.ok().body("register success");
    }
}
