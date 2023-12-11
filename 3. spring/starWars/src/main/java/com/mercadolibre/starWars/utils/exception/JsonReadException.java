package com.mercadolibre.starWars.utils.exception;

/**
 * Exception thrown when there is an error reading a JSON file.
 */
public class JsonReadException extends RuntimeException{

    public JsonReadException(String message) {
        super(message);
    }
}
