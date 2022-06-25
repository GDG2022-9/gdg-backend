package com.gdg.gdgbackend.global.error.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    // 회원
    MEMBER_NOT_EXIST(400, "해당 회원은 존재하지 않습니다."),
    ALREADY_REGISTERED_MEMBER(400, "이미 가입된 회원입니다."),
    MISMATCHED_PASSWORD(401, "패스워드가 일치하지 않습니다."),
    LOGIN_ERROR(401, "아이디 또는 비밀번호를 확인해주세요"),

    // 게시판
    MEET_NOT_EXIST(400, "해당 밋트는 존재는지 않습니다.");

    ErrorCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    private int status;
    private String message;

}