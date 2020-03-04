package com.example.project.components.ExceptionsAndAdvices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class DuplicateTelephoneNumberAdvice {

    @ResponseBody
    @ExceptionHandler(value = DuplicateTelephoneNumberException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
   public String duplicateTelephoneNumberHandler(DuplicateTelephoneNumberException ex){
       return ex.getMessage();
   }
}
