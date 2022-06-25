package com.gdg.gdgbackend.web.main.controller;

import com.gdg.gdgbackend.global.config.security.UserDetailsImpl;
import com.gdg.gdgbackend.web.main.dto.MainDto;
import com.gdg.gdgbackend.web.main.service.MainService;
import com.gdg.gdgbackend.web.myPage.dto.MyPageDto;
import com.gdg.gdgbackend.web.myPage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    private final MyPageService myPageService;

    @GetMapping("/main")
    public ResponseEntity getMain(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        String loginId = userDetails.getUsername();
        MainDto mainDto = mainService.getMain(loginId);

        return ResponseEntity.ok(mainDto);
    }

    @PostMapping("/main")
    public ResponseEntity registerTrip(@AuthenticationPrincipal UserDetails userDetails,
                                       @RequestBody MyPageDto myPageDto) {

        myPageService.registerTrip(userDetails, myPageDto);

        return ResponseEntity.ok().body("register success");

    }
}
