package com.sprint.be_java_hisp_w23_g04.exception;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message) {
        super(message);
    }
}
