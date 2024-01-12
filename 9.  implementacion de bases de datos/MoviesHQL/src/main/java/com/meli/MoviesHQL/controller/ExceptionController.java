package com.meli.MoviesHQL.controller;

import com.meli.MoviesHQL.dto.MessageDto;
import com.meli.MoviesHQL.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<MessageDto> exception(NotFoundException exception) {
        MessageDto message = new MessageDto(exception.getMessage());
        return ResponseEntity.status(404).body(message);
    }

}
