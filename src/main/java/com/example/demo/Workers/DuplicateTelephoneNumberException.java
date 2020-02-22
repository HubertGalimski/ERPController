package com.example.demo.Workers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Użytkownik z takim numerem telefonu już istnieje")
class DuplicateTelephoneNumberException extends RuntimeException {
}
