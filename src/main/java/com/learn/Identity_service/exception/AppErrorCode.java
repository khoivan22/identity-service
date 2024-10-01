package com.learn.Identity_service.exception;

import lombok.Getter;

@Getter
public enum AppErrorCode {

    USER_EXISTED(1001, "User existed."),
    USER_NOT_FOUND(1002, "User not found."),
    USERNAME_INVALID(1003, "Username invalid."),
    INVALID_MESSAGE_KEY(1004, "Invalid message key."),
    USER_NOT_EXISTED(1005, "User not existed."),
    UNAUTHENTICATED(1006, "Unauthenticated"),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error")
    ;
    private int code;
    private String message;

    AppErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
