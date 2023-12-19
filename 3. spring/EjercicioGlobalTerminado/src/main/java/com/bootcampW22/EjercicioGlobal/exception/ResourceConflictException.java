package com.bootcampW22.EjercicioGlobal.exception;

public class ResourceConflictException extends RuntimeException{
    public ResourceConflictException() {
    }

    public ResourceConflictException(String message) {
        super(message);
    }
}
