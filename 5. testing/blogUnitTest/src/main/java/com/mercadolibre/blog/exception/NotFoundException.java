package com.mercadolibre.blog.exception;

public class NotFoundException extends RuntimeException{
    private static final String message = "No se encontraron blogs con ese id";
    public NotFoundException() {
        super(message);
    }
}
