package com.learn.Identity_service.exception;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserException extends RuntimeException{


    private UserErrorCode userErrorCode;

    public UserException(UserErrorCode errorCode) {
        super(errorCode.getMessage());
        this.userErrorCode = errorCode;
    }
}
