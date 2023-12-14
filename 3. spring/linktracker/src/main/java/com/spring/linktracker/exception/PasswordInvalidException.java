package com.spring.linktracker.exception;

public class PasswordInvalidException extends RuntimeException{

    public PasswordInvalidException(String message) {
        super(message);
    }
}
