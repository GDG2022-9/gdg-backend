package com.gdg.gdgbackend.web.login.controller;

import com.gdg.gdgbackend.global.error.exception.ErrorCode;
import com.gdg.gdgbackend.web.login.service.LoginService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @ApiOperation(value = "로그인")
    @GetMapping("/login")
    public ResponseEntity login(@RequestParam(required = false) String isError) {

        if (Boolean.valueOf(isError)) {
            return ResponseEntity.badRequest().body(ErrorCode.LOGIN_ERROR.getMessage());
        }

        return ResponseEntity.ok().body("login success");
    }

//    @PostMapping("/register")

}

