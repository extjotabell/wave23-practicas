package org.ejercicio.joyeria.controller;

import org.apache.coyote.BadRequestException;
import org.ejercicio.joyeria.DTO.response.SimpleMessageDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class exceptionController {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<SimpleMessageDTO> badRequest(BadRequestException e) {
        SimpleMessageDTO exceptionDto = new SimpleMessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
