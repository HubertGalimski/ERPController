package com.example.project.components.ExceptionsAndAdvices;

public class  DuplicateTelephoneNumberException extends RuntimeException {

    public DuplicateTelephoneNumberException() {
        super("Podany numer telefonu istnieje w bazie");
    }
}
