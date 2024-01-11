package com.meli.QATesters.controller;

import com.meli.QATesters.dto.MessageDTO;
import com.meli.QATesters.exception.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDTO> notFoundException(NotFoundException e) {
        MessageDTO response = new MessageDTO(e.getMessage());
        return ResponseEntity.status(404).body(response);
    }

}
