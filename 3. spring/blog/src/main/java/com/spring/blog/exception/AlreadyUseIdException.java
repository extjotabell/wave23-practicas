package com.spring.blog.exception;

public class AlreadyUseIdException extends RuntimeException {
    public AlreadyUseIdException(String message) {
        super(message);
    }
}
