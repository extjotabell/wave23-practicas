package com.meli.blogapi.exception;

import com.meli.blogapi.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handlerNotFoundExcepcion(NotFoundException e){
        System.out.println("En handler...");
        ErrorDTO error = new ErrorDTO(e.getMessage(), "ID");
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateIdException.class)
    public ResponseEntity<ErrorDTO> handlerDuplicateIdException(DuplicateIdException e){
        ErrorDTO error = new ErrorDTO(e.getMessage(), "ID");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
