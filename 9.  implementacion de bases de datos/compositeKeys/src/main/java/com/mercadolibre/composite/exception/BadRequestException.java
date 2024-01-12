package com.mercadolibre.composite.exception;


public class BadRequestException extends RuntimeException{
    private static final String message = "Datos mal introducidos, procede a realizarlo nuevamente";
    public BadRequestException() {
        super(message);
    }
}