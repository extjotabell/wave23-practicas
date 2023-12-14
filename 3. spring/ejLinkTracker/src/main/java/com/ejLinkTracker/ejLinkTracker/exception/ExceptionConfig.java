package com.ejLinkTracker.ejLinkTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(UrlInvalidException.class)
    public ResponseEntity<?> urlInvalidException(UrlInvalidException urlInvalidException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(urlInvalidException.getMessage());
    }

    @ExceptionHandler(LinkTrackerNotValidException.class)
    public ResponseEntity<?> linkTrackerException(LinkTrackerNotValidException linkTracker) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(linkTracker.getMessage());
    }

}
