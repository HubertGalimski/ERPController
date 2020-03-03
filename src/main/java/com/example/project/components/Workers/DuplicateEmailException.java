package com.example.project.components.Workers;
class DuplicateEmailException extends RuntimeException {

    DuplicateEmailException() {
        super("Podany email istnieje w bazie");
    }
}
