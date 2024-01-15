package com.meli.Empleados.controller;

import com.meli.Empleados.dto.MessageDto;
import com.meli.Empleados.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        MessageDto messageDto = new MessageDto(e.getMessage());
        return ResponseEntity.status(404).body(messageDto);
    }

}
