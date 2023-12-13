package com.example.ejercicio_blog.exception;

public class AlreadyUsedIdException extends RuntimeException{
    public AlreadyUsedIdException(String message) {
        super(message);
    }
}
