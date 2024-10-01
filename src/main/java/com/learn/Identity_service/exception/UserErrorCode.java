package com.learn.Identity_service.exception;

import lombok.Getter;

@Getter
public enum UserErrorCode {

    USER_EXISTED(101, "User existed."),
    USER_NOTFOUND(404, "User not found."),
    USERNAME_INVALID(400, "Username invalid."),
    INVALID_MESSAGE_KEY(500, "Invalid message key.")
    ;
    private int code;
    private String message;

    UserErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
