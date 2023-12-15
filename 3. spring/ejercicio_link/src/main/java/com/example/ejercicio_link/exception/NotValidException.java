package com.example.ejercicio_link.exception;

public class NotValidException extends RuntimeException{
    public NotValidException(String message) {
        super(message);
    }
}