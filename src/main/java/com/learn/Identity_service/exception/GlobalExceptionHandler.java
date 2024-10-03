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

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handleRuntimeException(RuntimeException exception) {

        log.error("Exception: ", exception);
        ApiResponse apiResponse = ApiResponse.builder()
                .code(AppErrorCode.UNCATEGORIZED_EXCEPTION.getCode())
                .message(AppErrorCode.UNCATEGORIZED_EXCEPTION.getMessage())
                .build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handleUserException(AppException exception) {
        log.info("start AppException.....");
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
        log.info("start MethodArgumentNotValidException.....");
        AppErrorCode errorCode = AppErrorCode.INVALID_MESSAGE_KEY;
        try{
            errorCode = AppErrorCode.valueOf(exception.getFieldError().getDefaultMessage());
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