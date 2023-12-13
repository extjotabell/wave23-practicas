package com.itbootcamp.Blog.exception;

public class LlaveDuplicadaException extends RuntimeException{
    public LlaveDuplicadaException(String mensaje) {
        super(mensaje);
    }
}
