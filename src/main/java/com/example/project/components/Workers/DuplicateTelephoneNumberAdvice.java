package com.example.project.components.Workers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class DuplicateTelephoneNumberAdvice {

    @ResponseBody
    @ExceptionHandler(value = DuplicateTelephoneNumberException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
   String duplicateTelephoneNumberHandler(DuplicateTelephoneNumberException ex){
       return ex.getMessage();
   }
}
