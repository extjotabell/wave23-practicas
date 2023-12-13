package com.meli.linktracker.exception;

import com.meli.linktracker.dto.response.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(LinkAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> linkAlreadyExists(LinkAlreadyExistsException e) {
        return new ResponseEntity<>(
            new ExceptionDto(e.getMessage()),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InvalidLinkException.class)
    public ResponseEntity<ExceptionDto> invalidLink(InvalidLinkException e) {
        return new ResponseEntity<>(
            new ExceptionDto(e.getMessage()),
            HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(InexistentLinkException.class)
    public ResponseEntity<ExceptionDto> inexistentLink(InexistentLinkException e) {
        return new ResponseEntity<>(
            new ExceptionDto(e.getMessage()),
            HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(IncorrectPasswordException.class)
    public ResponseEntity<ExceptionDto> incorrectPassword(IncorrectPasswordException e) {
        return new ResponseEntity<>(
            new ExceptionDto(e.getMessage()),
            HttpStatus.UNAUTHORIZED
        );
    }

    @ExceptionHandler(InvalidURLException.class)
    public ResponseEntity<ExceptionDto> invalidURL(InvalidURLException e) {
        return new ResponseEntity<>(
            new ExceptionDto(e.getMessage()),
            HttpStatus.BAD_REQUEST
        );
    }
}
