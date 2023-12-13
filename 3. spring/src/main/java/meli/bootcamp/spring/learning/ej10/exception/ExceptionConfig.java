package meli.bootcamp.spring.learning.ej10.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import meli.bootcamp.spring.learning.ej10.dto.response.BaseDto;

@ControllerAdvice
public class ExceptionConfig {

  @ExceptionHandler(UnavailableIdException.class)
  public ResponseEntity<BaseDto> unavailableIdException(Exception e) {
    BaseDto response = new BaseDto(e.getMessage(), false);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(BlogNotFoundException.class)
  public ResponseEntity<BaseDto> blogNotFoundException(Exception e) {
    BaseDto response = new BaseDto(e.getMessage(), false);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }

  @ExceptionHandler(NoBlogsFoundException.class)
  public ResponseEntity<BaseDto> noBlogsFoundException(Exception e) {
    BaseDto response = new BaseDto(e.getMessage(), false);
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  }
}
