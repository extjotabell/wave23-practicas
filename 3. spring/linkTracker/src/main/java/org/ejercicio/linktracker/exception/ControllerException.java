package org.ejercicio.linktracker.exception;

import org.ejercicio.linktracker.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {

    @ExceptionHandler(LinkNotFoundException.class)
    public ResponseEntity<?> notFound(LinkNotFoundException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(LinkInvalidPasswordException.class)
    public ResponseEntity<?> invalidPassword(LinkInvalidPasswordException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(LinkInactiveException.class)
    public ResponseEntity<?> inactiveURL(LinkInactiveException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(LinkAlreadyExistException.class)
    public ResponseEntity<?> inactiveURL(LinkAlreadyExistException e) {
        ExceptionDto exceptionDto = new ExceptionDto(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
