package com.example.linktracker.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler
    public ResponseEntity<?> handlerLinkNotFoundException(LinkNotFoundException exception) {
        return ResponseEntity.status(404).body(new ExceptionDTO(404, exception.getMessage()));
    }
    @ExceptionHandler
    public ResponseEntity<?> handlerLinkInvalidPasswordException(LinkInvalidPasswordException exception) {
        return ResponseEntity.status(400).body(new ExceptionDTO(400, exception.getMessage()));
    }
    @ExceptionHandler
    public ResponseEntity<?> handlerLinkInactiveException(LinkInactiveException exception) {
        return ResponseEntity.status(400).body(new ExceptionDTO(400, exception.getMessage()));
    }

}
