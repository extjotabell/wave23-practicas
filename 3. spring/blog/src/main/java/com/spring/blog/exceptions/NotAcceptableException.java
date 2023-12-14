package com.spring.blog.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NotAcceptableException extends RuntimeException{

    public NotAcceptableException(String message){
        super(message);
    }
}
