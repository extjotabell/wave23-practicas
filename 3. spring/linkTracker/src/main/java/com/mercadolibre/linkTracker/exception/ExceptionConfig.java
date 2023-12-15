package com.mercadolibre.linkTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler configuration for the Link Tracker application.
 */
@ControllerAdvice
public class ExceptionConfig {

    /**
     * Handles the exception when an invalid URL is encountered.
     *
     * @param urlInvalidException The exception indicating an invalid URL.
     * @return ResponseEntity with a status of NOT_FOUND and the exception message.
     */
    @ExceptionHandler(UrlInvalidException.class)
    public ResponseEntity<?> urlInvalidException(UrlInvalidException urlInvalidException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(urlInvalidException.getMessage());
    }

    /**
     * Handles the exception when a Link Tracker entity is not valid.
     *
     * @param LinkTrackerNotValidException The exception indicating that a Link Tracker entity is not valid.
     * @return ResponseEntity with a status of NOT_FOUND and the exception message.
     */
    @ExceptionHandler(LinkTrackerNotValidException.class)
    public ResponseEntity<?> linkTrackerException(LinkTrackerNotValidException linkTracker) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(linkTracker.getMessage());
    }

    /**
     * Handles the exception when a Link Tracker entity is not found.
     *
     * @param linkTrackerNotFoundException The exception indicating that a Link Tracker entity is not found.
     * @return ResponseEntity with a status of NOT_FOUND and the exception message.
     */
    @ExceptionHandler(LinkTrackerNotFoundException.class)
    public ResponseEntity<?> linkTrackerNotFoundException(LinkTrackerNotFoundException linkTracker) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(linkTracker.getMessage());
    }

}
