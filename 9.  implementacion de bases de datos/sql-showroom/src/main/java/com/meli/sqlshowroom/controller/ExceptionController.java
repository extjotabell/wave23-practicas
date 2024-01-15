package com.meli.sqlshowroom.controller;

import com.meli.sqlshowroom.dto.MessageDTO;
import com.meli.sqlshowroom.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundException(NotFoundException e) {
        MessageDTO exceptionDto = new MessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }
}
