package com.meli.MiniSeries.exception;

import com.meli.MiniSeries.dto.ExceptionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFoundException(NotFoundException e) {
        return ResponseEntity.status(404).body(new ExceptionDTO("NotFoundException", e.getMessage()));
    }

}
