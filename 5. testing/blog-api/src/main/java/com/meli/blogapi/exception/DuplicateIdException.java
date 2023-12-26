package com.meli.blogapi.exception;

public class DuplicateIdException extends  RuntimeException{
    public DuplicateIdException(String message) {
        super(message);
    }
}
