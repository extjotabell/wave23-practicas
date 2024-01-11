package com.meli.Joyeria.controller;

import com.meli.Joyeria.dto.MessageDTO;
import com.meli.Joyeria.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundException(NotFoundException e) {
        MessageDTO message = new MessageDTO(e.getMessage());
        return ResponseEntity.status(404).body(message);
    }

}
