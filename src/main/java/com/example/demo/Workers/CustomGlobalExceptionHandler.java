package com.example.demo.Workers;

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

@ControllerAdvice
public class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler {
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
    public final ResponseEntity<Object> handleConstraintViolationException(Exception ex, WebRequest request) {

        ResponseDTO<Object> responseDTO = ResponseDTO.builder()
                .status(HttpStatus.BAD_REQUEST.toString())
                .message(ex.getMessage()).build();

        return ResponseEntity.badRequest().body(responseDTO);
    }
}