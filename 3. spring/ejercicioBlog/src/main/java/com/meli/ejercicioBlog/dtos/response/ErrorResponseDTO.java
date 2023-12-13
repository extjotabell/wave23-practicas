package com.meli.ejercicioBlog.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter @AllArgsConstructor
public class ErrorResponseDTO {
    private int status;
    private String message;
}
