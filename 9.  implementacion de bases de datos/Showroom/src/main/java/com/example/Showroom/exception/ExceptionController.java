package com.example.Showroom.exception;

import com.example.Showroom.model.dto.response.BaseResponseDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
    public ResponseEntity<BaseResponseDto> notFoundException(NotFoundException e) {
        BaseResponseDto exceptionDto = new BaseResponseDto(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDto);
    }
}
