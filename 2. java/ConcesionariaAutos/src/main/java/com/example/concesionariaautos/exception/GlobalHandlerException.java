package com.example.concesionariaautos.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {
    @ExceptionHandler(VehicleNotFound.class)
    public ResponseEntity<?> VehicleNotFoundException(Exception e) {
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(VehicleDuplicate.class)
    public ResponseEntity<?> VehicleDuplicateException(Exception e) {
        return ResponseEntity.status(409).body(e.getMessage());
    }
}
