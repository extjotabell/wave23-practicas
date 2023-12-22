package com.meli.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.meli.obtenerdiploma.model.ExceptionMessageDto;

@ControllerAdvice
public class ExceptionHandlerConfig {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ExceptionMessageDto> handleValidationException(MethodArgumentNotValidException ex) {
    ExceptionMessageDto response = new ExceptionMessageDto(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  protected ResponseEntity<ExceptionMessageDto> handleValidationExceptions(HttpMessageNotReadableException ex) {
    ExceptionMessageDto response = new ExceptionMessageDto(ex.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
