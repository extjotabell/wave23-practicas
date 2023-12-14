package com.ejercicioBlog.ejercicioBlog.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(){}
    public NotFoundException(String message) { super(message); }
}
