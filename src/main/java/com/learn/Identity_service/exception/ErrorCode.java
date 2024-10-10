package com.learn.Identity_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {

    USER_EXISTED(1001, "User existed.", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1002, "User not found.", HttpStatus.NOT_FOUND),
    USERNAME_INVALID(1003, "Username invalid.", HttpStatus.BAD_REQUEST),
    INVALID_MESSAGE_KEY(1004, "Invalid message key.", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed.", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006, "Unauthenticated", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1007, "You don't have permission", HttpStatus.FORBIDDEN),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR);

    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code, String message, HttpStatusCode statusCode) {
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }

}
