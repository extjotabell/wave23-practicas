package com.sprint.be_java_hisp_w23_g04.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
