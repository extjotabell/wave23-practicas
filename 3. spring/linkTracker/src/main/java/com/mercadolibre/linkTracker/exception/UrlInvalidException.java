package com.mercadolibre.linkTracker.exception;

public class UrlInvalidException extends RuntimeException{
    public UrlInvalidException(String message){
        super(message);
    }
}
