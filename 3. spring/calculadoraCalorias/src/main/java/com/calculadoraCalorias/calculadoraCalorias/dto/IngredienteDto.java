package com.calculadoraCalorias.calculadoraCalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
public class IngredienteDto {
    private String name;
    private int calories;
}
