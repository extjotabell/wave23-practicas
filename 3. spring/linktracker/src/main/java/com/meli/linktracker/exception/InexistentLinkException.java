package com.meli.linktracker.exception;

public class InexistentLinkException extends RuntimeException {
    public InexistentLinkException(String message) {
        super(message);
    }
}
