package com.meli.socialmeli.exceptions.custom;

public class NotFoundException extends  RuntimeException{
    public NotFoundException(String message) {
        super(message);
    }
}
