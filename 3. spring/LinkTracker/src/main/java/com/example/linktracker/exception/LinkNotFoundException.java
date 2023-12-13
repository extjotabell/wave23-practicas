package com.example.linktracker.exception;

public class LinkNotFoundException extends RuntimeException {
    public LinkNotFoundException(Long id) {
        super("No existe un link con el id = " + id);
    }
}
