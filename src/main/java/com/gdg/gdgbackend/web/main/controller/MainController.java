package com.gdg.gdgbackend.web.main.controller;

import com.gdg.gdgbackend.global.config.security.UserDetailsImpl;
import com.gdg.gdgbackend.web.main.dto.MainDto;
import com.gdg.gdgbackend.web.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;

    @GetMapping("/main")
    public ResponseEntity getMain(@AuthenticationPrincipal UserDetailsImpl userDetails) {

        String loginId = userDetails.getUsername();
        MainDto mainDto = mainService.getMain(loginId);

        return ResponseEntity.ok(mainDto);
    }
}
