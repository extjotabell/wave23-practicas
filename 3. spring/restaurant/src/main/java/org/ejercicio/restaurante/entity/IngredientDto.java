package org.ejercicio.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IngredientDto {
    private String foodName;
    private Double totalCalories;
}
