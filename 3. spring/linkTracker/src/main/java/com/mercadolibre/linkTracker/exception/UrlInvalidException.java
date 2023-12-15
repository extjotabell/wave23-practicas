package com.mercadolibre.linkTracker.exception;

/**
 * Exception thrown when an invalid URL is encountered.
 */
public class UrlInvalidException extends RuntimeException{
    public UrlInvalidException(String message){
        super(message);
    }
}
