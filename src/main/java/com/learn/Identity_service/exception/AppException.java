package com.learn.Identity_service.exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AppException extends RuntimeException{


    private AppErrorCode userErrorCode;

    public AppException(AppErrorCode errorCode) {
        super(errorCode.getMessage());
        this.userErrorCode = errorCode;
    }
}
