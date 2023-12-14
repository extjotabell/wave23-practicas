package com.spring.linktracker.exception;

public class LinkInactiveException extends RuntimeException{
    public LinkInactiveException(String message) {
        super(message);
    }
}
