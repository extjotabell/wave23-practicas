package com.example.linktracker.exception;

public class LinkInactiveException extends RuntimeException{
    public LinkInactiveException(Long id) {
        super("El link de ID = " + id + " se encuentra inactivo");
    }
}
