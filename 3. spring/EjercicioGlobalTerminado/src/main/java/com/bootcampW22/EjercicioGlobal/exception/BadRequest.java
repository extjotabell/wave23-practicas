package com.bootcampW22.EjercicioGlobal.exception;

public class BadRequest extends RuntimeException{
    public BadRequest() {
    }

    public BadRequest(String message) {
        super(message);
    }
}
