package com.meli.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class ConflictException extends RuntimeException{

    public ConflictException(String message) {
        super(message);
    }
}
