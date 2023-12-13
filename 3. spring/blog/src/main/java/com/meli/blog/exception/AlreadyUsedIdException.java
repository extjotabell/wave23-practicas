package com.meli.blog.exception;

public class AlreadyUsedIdException extends RuntimeException {

    public AlreadyUsedIdException(String message) {
        super(message);
    }
}
