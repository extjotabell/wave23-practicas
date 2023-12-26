package com.ospina.blogYoutuber.excepcion;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntradaBlogNoEncontradaExcepcion.class)
    public ResponseEntity<?> entradaBlogNoEncontrada(EntradaBlogNoEncontradaExcepcion e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EntradaBlogExistenteExcepcion.class)
    public ResponseEntity<?> entradaBlogNoEncontrada(EntradaBlogExistenteExcepcion e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
