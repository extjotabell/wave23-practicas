package com.meli.socialmeli.exceptions;

import com.meli.socialmeli.dtos.response.ErrorDTO;
import com.meli.socialmeli.dtos.response.ExceptionDTO;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.exceptions.custom.DataSourceException;
import com.meli.socialmeli.exceptions.custom.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handlerNotFoundExcepcion(NotFoundException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataSourceException.class)
    public ResponseEntity<?> handlerDataSoureException(DataSourceException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handlerMethodArgument(MethodArgumentTypeMismatchException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> handleBadRequestException(BadRequestException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

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