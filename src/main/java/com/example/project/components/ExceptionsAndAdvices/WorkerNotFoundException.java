package com.example.project.components.ExceptionsAndAdvices;

public class WorkerNotFoundException extends RuntimeException {

   public WorkerNotFoundException() {
        super("Podany pracownik o takim ID nie istnieje");
    }
}
