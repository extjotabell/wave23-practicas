package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDto {
    private String explanation;
    private List<String> message;
}
