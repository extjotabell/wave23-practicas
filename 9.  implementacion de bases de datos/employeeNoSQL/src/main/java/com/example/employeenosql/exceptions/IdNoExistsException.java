package com.example.employeenosql.exceptions;

public class IdNoExistsException extends RuntimeException{
    private static final String MESSAGE = "Id don't exists.";
    public IdNoExistsException() {
        super(MESSAGE);
    }
}
