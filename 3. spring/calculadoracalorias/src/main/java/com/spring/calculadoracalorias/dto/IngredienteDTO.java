package com.spring.calculadoracalorias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IngredienteDTO {
    private String nombre;
    private int calorias;
    private int gramos;
}
