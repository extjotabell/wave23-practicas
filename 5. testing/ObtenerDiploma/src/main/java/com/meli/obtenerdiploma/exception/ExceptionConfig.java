package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.ErrorDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.validation.ConstraintViolation;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handlerValidationException(MethodArgumentNotValidException e){
        return ResponseEntity.badRequest()
                             .body(new ErrorDTO(ErrorDTO.generalMessage,
                                                e.getAllErrors().stream()
                                                 .map(DefaultMessageSourceResolvable::getDefaultMessage).toList()));

    }
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handlerValidationException(ConstraintViolationException e){
        return ResponseEntity.badRequest()
                .body(new ErrorDTO(ErrorDTO.generalMessage,
                        e.getConstraintViolations().stream()
                                .map(ConstraintViolation::getMessage).toList()));
    }
}
