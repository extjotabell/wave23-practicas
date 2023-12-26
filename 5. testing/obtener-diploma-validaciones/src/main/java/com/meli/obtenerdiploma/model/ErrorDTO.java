package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String description;
    private List<String> messages;
}
