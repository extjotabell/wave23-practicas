package com.meli.autos.exception;

import com.meli.autos.exception.custom.VehicleException;
import com.meli.autos.exception.custom.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(VehicleException.class)
    public ResponseEntity<Error>  handleRequestException(VehicleException e){
        return new ResponseEntity<>(new Error(e.getMessage(), "ID"), HttpStatus.NOT_FOUND);
    }
}
