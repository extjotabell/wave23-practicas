package com.ospina.showroom.modelo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionDTO {
    private String message;

    private List<String> errors;

    public ExceptionDTO(String message) {
        this.message = message;
    }

    public ExceptionDTO(String message, List<String> errors) {
        this.message = message;
        this.errors = errors;
    }
}


