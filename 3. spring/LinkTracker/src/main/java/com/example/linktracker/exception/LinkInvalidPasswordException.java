package com.example.linktracker.exception;

public class LinkInvalidPasswordException extends RuntimeException {
    public LinkInvalidPasswordException() {
        super("La contraseña indicada es invalida");
    }
}
