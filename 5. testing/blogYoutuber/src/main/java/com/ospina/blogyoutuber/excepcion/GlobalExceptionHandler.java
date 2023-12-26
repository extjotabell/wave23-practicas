package com.ospina.blogyoutuber.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidacionExcepcion.class)
    public ResponseEntity<?> validationException(ValidacionExcepcion e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }


    @ExceptionHandler(EntradaBlogNoEncontradaExcepcion.class)
    public ResponseEntity<?> entradaBlogNoEncontrada(EntradaBlogNoEncontradaExcepcion e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(EntradaBlogExistenteExcepcion.class)
    public ResponseEntity<?> entradaBlogNoEncontrada(EntradaBlogExistenteExcepcion e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }
}
