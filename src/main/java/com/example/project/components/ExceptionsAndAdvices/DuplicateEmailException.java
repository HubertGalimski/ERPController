package com.example.project.components.ExceptionsAndAdvices;
public class DuplicateEmailException extends RuntimeException {

     public DuplicateEmailException() {
        super("Podany email istnieje w bazie");
    }
}
