package com.example.joyerialasperlas.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionGlobal {
  @ExceptionHandler
  public ResponseEntity<String> illegalCreationJewelException(IllegalJewelCreationException exception){
    return ResponseEntity.badRequest().body(exception.getMessage());
  }

    @ExceptionHandler
    public ResponseEntity<String> JewelNotFoundException(JewelNotFoundException exception){
      return ResponseEntity.status(404).body(exception.getMessage());
    }
}
