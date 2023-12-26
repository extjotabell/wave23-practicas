package com.example.youtuber.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class ExceptionConfig {

    @ExceptionHandler(BlogAlreadyExistException.class)
    public ResponseEntity<?> entryBlogException(BlogAlreadyExistException entryBlogException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(entryBlogException.getMessage());
    }

    @ExceptionHandler(BlogDoesNotExistException.class)
    public ResponseEntity<?> entryBlogException(BlogDoesNotExistException entryBlogException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entryBlogException.getMessage());
    }
}
