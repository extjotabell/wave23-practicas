package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO {
    private String explanation;
    private List<String> errors;
}
