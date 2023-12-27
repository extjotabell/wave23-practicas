package com.mercadolibre.blog.exception;

public class ConflictException extends RuntimeException{
    private static final String message = "El blog ya existe en el sistema.";
    public ConflictException() {
        super(message);
    }
}
