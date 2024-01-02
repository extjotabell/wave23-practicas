package com.sprint.be_java_hisp_w23_g04.controller;

import com.sprint.be_java_hisp_w23_g04.exception.BadRequestException;
import com.sprint.be_java_hisp_w23_g04.exception.NoContentException;
import com.sprint.be_java_hisp_w23_g04.exception.NotFoundException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.HandlerMethodValidationException;


@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<SimpleMessageDTO> notFoundException(NotFoundException e) {
        SimpleMessageDTO exceptionDto = new SimpleMessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<SimpleMessageDTO> badRequest(BadRequestException e) {
        SimpleMessageDTO exceptionDto = new SimpleMessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<SimpleMessageDTO> emptyContent(NoContentException e) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<SimpleMessageDTO> validationException(UnexpectedTypeException e) {
        SimpleMessageDTO errorDTO = new SimpleMessageDTO(e.getMessage());
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<SimpleMessageDTO> validationException(MethodArgumentNotValidException e) {
        SimpleMessageDTO errorDTO = new SimpleMessageDTO(
                "Se encontraron los siguientes errores en las validaciones:",
                e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HandlerMethodValidationException.class)
    public ResponseEntity<SimpleMessageDTO> validationException(HandlerMethodValidationException e) {
        SimpleMessageDTO errorDTO = new SimpleMessageDTO(
                "Se encontraron los siguientes errores en las validaciones:",
                e.getAllErrors().stream().map(MessageSourceResolvable::getDefaultMessage).toList()
        );
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }
}
