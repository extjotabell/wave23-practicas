package com.spring.blog.exception;

import com.spring.blog.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(AlreadyUseIdException.class)
    public ResponseEntity<?> alreadyUseIdException(Exception ex) {
        ErrorDto error = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFound(NotFoundException out) {
        ErrorDto err = new ErrorDto(out.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
}
