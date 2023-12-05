package com.meli.encrypted.exception;

public class EncyptorException extends Exception {

    public static final String STRING_WITH_NUMBERS_EXCEPTION = "The string cannot contain numbers!";
    public EncyptorException(String message) {
        super(message);
    }
}
