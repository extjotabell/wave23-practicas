package com.ejercicioBlog.ejercicioBlog.exception;
import com.ejercicioBlog.ejercicioBlog.dto.response.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> handleBadRequestException(BadRequestException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> handleNotFoundException(NotFoundException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
