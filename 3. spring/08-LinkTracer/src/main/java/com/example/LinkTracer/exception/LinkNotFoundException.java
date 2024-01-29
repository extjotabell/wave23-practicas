package com.example.LinkTracer.exception;

public class LinkNotFoundException extends RuntimeException {


    private static final long serialVersionUID = 1L;

    private static final String MENSAJE = "El link no fue encontrado.";

    public LinkNotFoundException() {
        super(MENSAJE);
    }
}
