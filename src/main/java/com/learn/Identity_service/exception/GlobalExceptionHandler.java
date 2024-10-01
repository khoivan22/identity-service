package com.learn.Identity_service.exception;

import com.learn.Identity_service.dto.Empty;
import com.learn.Identity_service.dto.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse<Empty>> handleRuntimeException(RuntimeException exception) {

        log.error("Exception: ", exception);
        ApiResponse<Empty> apiResponse = ApiResponse.<Empty>builder()
                .code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode())
                .message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage())
                .build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AccessDeniedException.class)
    ResponseEntity<ApiResponse<Empty>> handleAccessDeniedException(AccessDeniedException exception) {

        log.error("Exception: ", exception);
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        ApiResponse<Empty> apiResponse = ApiResponse.<Empty>builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();

        return ResponseEntity.status(errorCode.getStatusCode()).body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse<Empty>> handleUserException(AppException exception) {
        log.info("start AppException.....");
        ErrorCode errorCode = exception.getUserErrorCode();

        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(ApiResponse
                        .<Empty>builder()
                        .message(exception.getMessage())
                        .code(errorCode.getCode())
                        .build());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse<Empty>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        log.info("start MethodArgumentNotValidException.....");
        ErrorCode errorCode = ErrorCode.INVALID_MESSAGE_KEY;
        try {
            errorCode = ErrorCode.valueOf(Objects.requireNonNull(exception.getFieldError()).getDefaultMessage());
        } catch (Exception e) {
            log.error(e.getMessage() + 1);
        }

        return ResponseEntity
                .badRequest()
                .body(ApiResponse
                        .<Empty>builder()
                        .message(errorCode.getMessage())
                        .code(errorCode.getCode())
                        .build());
    }
}