package com.bootcamp.blog.exception;

public class AlreadyUsedIdException extends RuntimeException{
    public AlreadyUsedIdException(String message) {
        super(message);
    }
}
