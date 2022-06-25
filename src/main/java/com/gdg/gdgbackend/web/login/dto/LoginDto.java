package com.gdg.gdgbackend.web.login.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class LoginDto {

    @NotBlank(message = "아이디는 필수 입력 값 입니다.")
    private String loginId;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String password;
}
