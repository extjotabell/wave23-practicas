package com.meli.calorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoDto {
    private String name;
    private List<IngredienteDto> ingredientes;
    private double totalCalories;
    private IngredienteDto ingredienteMasCalorico;
}
