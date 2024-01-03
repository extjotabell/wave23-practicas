package com.mercadolibre.be_java_hisp_w23_g2.exception;

import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.ErrorDTO;
import com.mercadolibre.be_java_hisp_w23_g2.dto.responses.MessageDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler for handling specific exceptions and providing standardized responses.
 */
@ControllerAdvice
public class ExceptionConfig {

  /**
   * Handles NotFoundException and returns a ResponseEntity with a NOT_FOUND status and a MessageDTO
   * containing the exception message.
   *
   * @param e The NotFoundException that occurred.
   * @return ResponseEntity with NOT_FOUND status and a MessageDTO.
   */
  @ExceptionHandler
  public ResponseEntity<MessageDTO> notFoundException(NotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDTO(e.getMessage()));
  }

  /**
   * Handles BadRequestException and returns a ResponseEntity with a BAD_REQUEST status and a
   * MessageDTO containing the exception message.
   *
   * @param e The BadRequestException that occurred.
   * @return ResponseEntity with BAD_REQUEST status and a MessageDTO.
   */
  @ExceptionHandler
  public ResponseEntity<MessageDTO> badRequestException(BadRequestException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO(e.getMessage()));
  }

  /**
   * Handles NotFollowingException and returns a ResponseEntity with a CONFLICT status and a
   * MessageDTO containing the exception message.
   *
   * @param e The NotFollowingException that occurred.
   * @return ResponseEntity with CONFLICT status and a MessageDTO.
   */
  @ExceptionHandler
  public ResponseEntity<MessageDTO> notFollowingException(NotFollowingException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT).body(new MessageDTO(e.getMessage()));
  }

  /**
   * Handles MethodArgumentNotValidException and returns a ResponseEntity with a BAD_REQUEST status
   * and a MessageDTO containing the exception message.
   *
   * @param e The MethodArgumentNotValidException that occurred.
   * @return ResponseEntity with BAD_REQUEST status and a MessageDTO.
   */
  @ExceptionHandler
  public ResponseEntity<ErrorDTO> validationException(MethodArgumentNotValidException e) {
    List<String> messages = new ArrayList<>();
    e.getBindingResult().getFieldErrors().forEach(fieldError ->
        messages.add(fieldError.getDefaultMessage()));

    ErrorDTO errorDto = new ErrorDTO();
    errorDto.setExplanation("Se encontraron errores de validación");
    errorDto.setMessage(messages);

    return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
  }

  /**
   * Handles HttpMessageNotReadableException and returns a ResponseEntity with a BAD_REQUEST status
   * and a MessageDTO containing the exception message.
   *
   * @param e The HttpMessageNotReadableException that occurred.
   * @return ResponseEntity with BAD_REQUEST status and a MessageDTO.
   */
  @ExceptionHandler
  public ResponseEntity<MessageDTO> validationException(HttpMessageNotReadableException e) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageDTO(e.getMessage()));
  }
}
