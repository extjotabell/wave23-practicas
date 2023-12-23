package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getBindingResult().getFieldError().getDefaultMessage(), "MethodArgumentNotValidException");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleValidationExceptions(HttpMessageNotReadableException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(e.getMessage(), "HttpMessageNotReadableException");
        return ResponseEntity.badRequest().body(exceptionDTO);
    }

}
