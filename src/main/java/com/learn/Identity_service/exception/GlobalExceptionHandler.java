package com.learn.Identity_service.exception;

import com.learn.Identity_service.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<String> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(value = UserException.class)
    ResponseEntity<ApiResponse> handleUserException(UserException exception) {

        return ResponseEntity
                .badRequest()
                .body(ApiResponse
                        .builder()
                        .message(exception.getMessage())
                        .code(exception.getUserErrorCode().getCode())
                        .build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        UserErrorCode errorCode = UserErrorCode.INVALID_MESSAGE_KEY;
        try{
            errorCode = UserErrorCode.valueOf(exception.getFieldError().getDefaultMessage());
        }catch (Exception e){
            log.error(e.getMessage()+1);
        }

        return ResponseEntity
                .badRequest()
                .body(ApiResponse
                        .builder()
                        .message(errorCode.getMessage())
                        .code(errorCode.getCode())
                        .build());
    }
}