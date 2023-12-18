package meli.bootcamp.sprint1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import meli.bootcamp.sprint1.dto.response.BaseResponseDto;

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

}
