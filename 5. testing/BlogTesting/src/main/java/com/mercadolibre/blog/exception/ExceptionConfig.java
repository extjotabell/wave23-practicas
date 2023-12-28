package com.mercadolibre.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(EntryBlogAlreadyExistsException.class)
    public ResponseEntity<?> entryBlogException(EntryBlogAlreadyExistsException entryBlogException) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(entryBlogException.getMessage());
    }

    @ExceptionHandler(EntryBlogNotExistsException.class)
    public ResponseEntity<?> entryBlogNotExistsException(EntryBlogNotExistsException entryBlogNotExistsException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(entryBlogNotExistsException.getMessage());
    }
}
