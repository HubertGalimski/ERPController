package com.example.demo.Workers;

class  DuplicateTelephoneNumberException extends RuntimeException {

    protected DuplicateTelephoneNumberException() {
        super("Podany numer telefonu istnieje w bazie");
    }
}
