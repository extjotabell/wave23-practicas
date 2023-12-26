package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.context.support.DefaultMessageSourceResolvable;


import javax.validation.ConstraintViolationException;
import javax.validation.ConstraintViolation;
import javax.validation.UnexpectedTypeException;
import java.util.*;
import java.util.stream.Collectors;


public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDto> validationException(MethodArgumentNotValidException e) {
        ErrorDto errorDTO = new ErrorDto(
                "Se encontraron errores en las validaciones: ",
                e.getAllErrors().stream()
                        .map(DefaultMessageSourceResolvable::getDefaultMessage)
                        .collect(Collectors.toList())
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<ErrorDto> validationException(UnexpectedTypeException e) {
        ErrorDto errorDTO = new ErrorDto(
                "Se encontraron errores en las validaciones: ",
                Collections.singletonList(e.getMessage())
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDto> validationException(ConstraintViolationException e) {
        ErrorDto errorDTO = new ErrorDto(
                "Se encontraron errores en las validaciones: ",
                e.getConstraintViolations().stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.toList())
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
