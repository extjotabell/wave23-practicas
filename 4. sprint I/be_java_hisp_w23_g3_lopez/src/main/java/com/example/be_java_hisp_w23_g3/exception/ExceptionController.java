package com.example.be_java_hisp_w23_g3.exception;

import com.example.be_java_hisp_w23_g3.dto.response.ExceptionResponseDTO;
import com.example.be_java_hisp_w23_g3.exception.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ExceptionController {

    // Custom exceptions

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<?> validationException(ValidationException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(NotFoundException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<?> alreadyExistsProductException(AlreadyExistsException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    // Spring exceptions

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<?> dateTimeParseException(DateTimeParseException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> httpMessageNotReadableException(HttpMessageNotReadableException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(NotAFollowerException.class)
    public ResponseEntity<?> notAFollowerException(NotAFollowerException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(UnFollowingMyselfException.class)
    public ResponseEntity<?> unFollowingMyselfException(UnFollowingMyselfException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(FollowingMyselfException.class)
    public ResponseEntity<?> followingMyselfException(FollowingMyselfException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(AlreadyAFollowerException.class)
    public ResponseEntity<?> alreadyAFollowerException(AlreadyAFollowerException e){
        ExceptionResponseDTO exceptionDto = new ExceptionResponseDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

}
