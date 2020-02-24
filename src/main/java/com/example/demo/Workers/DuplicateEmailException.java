package com.example.demo.Workers;

public class DuplicateEmailException extends RuntimeException {

    protected DuplicateEmailException() {
        super("Podany email istnieje w bazie");
    }
}
