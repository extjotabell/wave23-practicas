package com.meli.ejercicioBlog.exceptions;

public class MalformedPayloadException extends RuntimeException{
    public MalformedPayloadException() {
        super();
    }

    public MalformedPayloadException(String message) {
        super(message);
    }
}
