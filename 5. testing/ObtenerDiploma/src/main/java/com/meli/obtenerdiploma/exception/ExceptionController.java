package com.meli.obtenerdiploma.exception;

import com.meli.obtenerdiploma.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)

    public ResponseEntity<ErrorDto> customHandleNotValidException(
            MethodArgumentNotValidException ex) {

        List<String> messages = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(fieldError ->
                messages.add(fieldError.getDefaultMessage()));

        ErrorDto errorDto = new ErrorDto();
        errorDto.setExplanation("Se encontraron errores de validación: ");
        errorDto.setMessage(messages);

        return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
    }

}
