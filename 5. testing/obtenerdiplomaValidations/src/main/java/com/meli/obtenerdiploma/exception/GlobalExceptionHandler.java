package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.dto.MessageDTO;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<MessageDTO> handleValidationException(ValidationException e) {
        List<String> errors = e.getErrors();
        return ResponseEntity.badRequest().body(new MessageDTO("Validation error", errors));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MessageDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<String> errors = Collections.singletonList(e.getBindingResult().getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toString());
        return ResponseEntity.badRequest().body(new MessageDTO("Validation error", errors));
    }

}
