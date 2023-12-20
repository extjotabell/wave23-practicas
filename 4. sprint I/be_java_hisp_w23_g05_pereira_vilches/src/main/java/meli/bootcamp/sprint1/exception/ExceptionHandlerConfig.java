package meli.bootcamp.sprint1.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import meli.bootcamp.sprint1.dto.response.BaseResponseDto;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlerConfig {

  @ExceptionHandler(BadRequestException.class)
  public ResponseEntity<BaseResponseDto> badRequestException(Exception e) {
    BaseResponseDto response = new BaseResponseDto(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }

  @ExceptionHandler(EmptyListException.class)
  public ResponseEntity<BaseResponseDto> emptyListException(Exception e){
    BaseResponseDto response = new BaseResponseDto(e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<BaseResponseDto> methodArgumentTypeMismatchException(Exception e){
    BaseResponseDto response = new BaseResponseDto("Some of the arguments are wrong." + " More info:" + e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
  
  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity<BaseResponseDto> httpMessageNotReadableException(Exception e){
    BaseResponseDto response = new BaseResponseDto("Some of the arguments are wrong." + " More info:" + e.getMessage());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
