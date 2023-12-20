package com.sprint.be_java_hisp_w23_g04.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.sprint.be_java_hisp_w23_g04.dto.response.SimpleMessageDTO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> NotFoundException(NotFoundException e) {
        SimpleMessageDTO exceptionDto = new SimpleMessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequest(BadRequestException e) {
        SimpleMessageDTO exceptionDto = new SimpleMessageDTO(e.getMessage());
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<?> emptyContent(NoContentException e) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
