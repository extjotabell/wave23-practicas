package com.ospina.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
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


