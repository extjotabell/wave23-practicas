package com.meli.obtenerdiploma.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ErrorDTO {
    public static final String generalMessage = "Se encontraron errores en las siguientes validaciones:";
    private String explanation;
    private List<String> messages;
}
