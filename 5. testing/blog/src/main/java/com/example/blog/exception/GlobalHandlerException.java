package com.example.blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler
    public ResponseEntity<?> handlerEntryBlogNotFoundException(EntryBlogNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(404, exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> handlerEntryBlogListEmptyException(EntryBlogListEmptyException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ExceptionDTO(404, exception.getMessage()));
    }

    @ExceptionHandler
    public ResponseEntity<?> handlerEntryBlogDuplicateException(EntryBlogDuplicateException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ExceptionDTO(409, exception.getMessage()));
    }
}
