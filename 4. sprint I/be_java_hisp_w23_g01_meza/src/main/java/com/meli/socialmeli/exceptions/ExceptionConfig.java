package com.meli.socialmeli.exceptions;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.meli.socialmeli.dtos.response.ExceptionDTO;
import com.meli.socialmeli.exceptions.custom.BadRequestException;
import com.meli.socialmeli.exceptions.custom.DataSourceException;
import com.meli.socialmeli.exceptions.custom.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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

    @ExceptionHandler(JsonMappingException.class)
    public ResponseEntity<ExceptionDTO> handleBadJsonPostBody(JsonMappingException e) {
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

}