package com.example.LinkTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerConfig {

    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<?> invalidURLException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }

    @ExceptionHandler(InvalidParamsException.class)
    public ResponseEntity<?> invalidParamsException(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }

}
