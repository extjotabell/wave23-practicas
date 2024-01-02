package com.example.be_java_hisp_w23_g3.exception;

import com.example.be_java_hisp_w23_g3.dto.response.ExceptionDTO;
import com.example.be_java_hisp_w23_g3.exception.exceptions.*;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> methodArgumentNotValidException(MethodArgumentNotValidException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(
            "Validation errors have occurred",
            e.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).toList()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionDTO> constraintViolationException(ConstraintViolationException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(
            "Validation errors have occurred",
            e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).toList()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDTO> httpMessageNotReadableException(HttpMessageNotReadableException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionDTO> validationException(ValidationException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> notFoundException(NotFoundException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<ExceptionDTO> alreadyExistsProductException(AlreadyExistsException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<ExceptionDTO> invalidOrderException(InvalidOrderException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<ExceptionDTO> dateTimeParseException(DateTimeParseException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

    @ExceptionHandler(NotFollowingException.class)
    public ResponseEntity<ExceptionDTO> notAFollowerException(NotFollowingException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(UnfollowingMyselfException.class)
    public ResponseEntity<ExceptionDTO> unFollowingMyselfException(UnfollowingMyselfException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(FollowingMyselfException.class)
    public ResponseEntity<ExceptionDTO> followingMyselfException(FollowingMyselfException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }
    @ExceptionHandler(AlreadyFollowingException.class)
    public ResponseEntity<ExceptionDTO> alreadyAFollowerException(AlreadyFollowingException e){
        ExceptionDTO exceptionDto = new ExceptionDTO(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDto);
    }

}
