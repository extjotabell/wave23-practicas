package com.mercadolibre.linkTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(UrlInvalidException.class)
    public ResponseEntity<?> urlInvalidException(UrlInvalidException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(LinkTrackerNotValidException.class)
    public ResponseEntity<?> linkTrackerNotValidException(LinkTrackerNotValidException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(LinkTrackerNotFoundException.class)
    public ResponseEntity<?> linkTrackerNotFoundException(LinkTrackerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

}
