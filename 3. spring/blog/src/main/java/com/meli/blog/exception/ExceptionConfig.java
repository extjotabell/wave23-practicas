package com.meli.blog.exception;

import com.meli.blog.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(AlreadyUsedIdException.class)
    public ResponseEntity<?> alreadyUsedIdException(Exception e) {
        return new ResponseEntity<>(new ErrorDto(
            e.getMessage(), 400),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(EntryNotFoundException.class)
    public ResponseEntity<?> entryNotFoundException(Exception e) {
        return new ResponseEntity<>(new ErrorDto(
            e.getMessage(), 404),
            HttpStatus.NOT_FOUND
        );
    }
}
