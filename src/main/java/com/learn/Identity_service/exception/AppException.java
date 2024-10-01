package com.learn.Identity_service.exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppException extends RuntimeException {


    private final ErrorCode userErrorCode;

    public AppException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.userErrorCode = errorCode;
    }
}
