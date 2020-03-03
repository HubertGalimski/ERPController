package com.example.project.components.Workers;

class  DuplicateTelephoneNumberException extends RuntimeException {

    DuplicateTelephoneNumberException() {
        super("Podany numer telefonu istnieje w bazie");
    }
}
