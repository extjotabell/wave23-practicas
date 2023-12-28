package meli.bootcamp.sprint1.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.UnexpectedTypeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import meli.bootcamp.sprint1.dto.response.BaseResponseDto;

import java.util.*;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandlerConfig {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<BaseResponseDto> badRequestException(Exception e) {
    BaseResponseDto response = new BaseResponseDto(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(EmptyListException.class)
  public ResponseEntity<BaseResponseDto> emptyListException(Exception e) {
    BaseResponseDto response = new BaseResponseDto(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<CustomException> customHandleNotValidException(
      MethodArgumentNotValidException ex) {

    List<String> messages = new ArrayList<>();
    ex.getBindingResult().getFieldErrors().forEach(fieldError -> messages.add(fieldError.getDefaultMessage()));

    CustomException customException = new CustomException();
    customException.setExplanation("Se encontraron errores de validación");
    customException.setMessage(messages);

    return new ResponseEntity<>(customException, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<CustomException> customConstraintViolationException(ConstraintViolationException e) {
    CustomException errorDTO = new CustomException(
        "Se encontraron errores de validaciones: ",
        e.getConstraintViolations().stream()
            .map(ConstraintViolation::getMessage)
            .collect(Collectors.toList()));
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(UnexpectedTypeException.class)
  public ResponseEntity<CustomException> customUnexpectedTypeException(UnexpectedTypeException e) {
    CustomException errorDTO = new CustomException(
        "Se encontraron errores de validaciones: ",
        Collections.singletonList(e.getMessage()));
    return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
  }

}
