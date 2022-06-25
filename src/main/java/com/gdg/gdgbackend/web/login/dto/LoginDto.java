package com.gdg.gdgbackend.web.login.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@ApiModel
public class LoginDto {

    @ApiModelProperty(required = true)
    @NotBlank(message = "아이디는 필수 입력 값 입니다.")
    private String loginId;

    @ApiModelProperty(required = true)
    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    private String password;
}
