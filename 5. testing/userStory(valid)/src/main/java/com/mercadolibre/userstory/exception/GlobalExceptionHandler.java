package com.mercadolibre.userstory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;


@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<CustomException> customHandleNotValidException(
            MethodArgumentNotValidException ex) {

        List<String> messages = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                messages.add(fieldError.getDefaultMessage()));

        CustomException customException = new CustomException();
        customException.setExplanation("Se encontraron errores de validación");
        customException.setMessage(messages);

        return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
    }
}
