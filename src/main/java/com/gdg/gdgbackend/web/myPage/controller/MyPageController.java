package com.gdg.gdgbackend.web.myPage.controller;

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
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("/mypage")
    public ResponseEntity getMyPage(@AuthenticationPrincipal UserDetails userDetails) {

        MyPageDto myPageDto = myPageService.getMyPage(userDetails);

        return ResponseEntity.ok(myPageDto);
    }

    @PostMapping("/mypage")
    public ResponseEntity registerTrip(@AuthenticationPrincipal UserDetails userDetails,
                                       @RequestBody MyPageDto myPageDto) {

        myPageService.registerTrip(userDetails, myPageDto);

        return ResponseEntity.ok().body("register success");

    }
}
