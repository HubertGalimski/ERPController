package com.example.project.util;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

 class HandlerException {
    @Data
    @Builder
    public static class ResponseDTO<T> {
        private String status;

        @Builder.Default
        private String message = "Success!";

        private T body;
    }

    @ControllerAdvice
    static class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler {

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {


            FieldError fieldError = ex.getBindingResult().getFieldError();
            assert fieldError != null;
            ResponseDTO<Object> responseDTO = ResponseDTO.builder()
                    .status(status.toString())
                    .message(fieldError.getDefaultMessage()).build();

            return ResponseEntity.badRequest().body(responseDTO);
        }

        @ExceptionHandler(ConstraintViolationException.class)
        final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {

            ResponseDTO<Object> responseDTO = ResponseDTO.builder()
                    .status(HttpStatus.BAD_REQUEST.toString())
                    .message(ex.getMessage()).build();

            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
