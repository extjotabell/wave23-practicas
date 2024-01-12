package com.meli.Vehiculos.controller;

import com.meli.Vehiculos.dto.response.MessageDTO;
import com.meli.Vehiculos.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e) {
        MessageDTO message = new MessageDTO(e.getMessage());
        return ResponseEntity.status(404).body(message);
    }

}
