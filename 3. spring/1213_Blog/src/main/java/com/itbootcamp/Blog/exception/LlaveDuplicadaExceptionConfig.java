package com.itbootcamp.Blog.exception;

import com.itbootcamp.Blog.dto.MensajeExcepcionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice(annotations = RestController.class)
public class LlaveDuplicadaExceptionConfig {
    @ExceptionHandler(LlaveDuplicadaException.class)
    public ResponseEntity<?> llaveDuplicadaException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new MensajeExcepcionDto(e.getMessage()));
    }
}
