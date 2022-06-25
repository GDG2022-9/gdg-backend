package com.gdg.gdgbackend.web.customMeet.controller;


import com.gdg.gdgbackend.web.customMeet.dto.CustomMeetDto;
import com.gdg.gdgbackend.web.customMeet.service.CustomMeetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CustomMeetController {

    private final CustomMeetService customMeetService;

    @GetMapping("/custom")
    public ResponseEntity getCustomMeet(@AuthenticationPrincipal UserDetails userDetails) {

        String loginId = userDetails.getUsername();
        CustomMeetDto customMeetDto = customMeetService.getCustomMeet(loginId);

        return ResponseEntity.ok(customMeetDto);
    }
}
