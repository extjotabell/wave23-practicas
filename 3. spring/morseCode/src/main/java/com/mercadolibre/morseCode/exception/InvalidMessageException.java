package com.mercadolibre.morseCode.exception;

public class InvalidMessageException extends RuntimeException{

    public InvalidMessageException(String message){
        super(message);
    }
}
