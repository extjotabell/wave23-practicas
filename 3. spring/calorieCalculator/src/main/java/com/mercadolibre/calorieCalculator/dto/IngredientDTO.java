package com.mercadolibre.calorieCalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data Transfer Object (DTO) representing information about an ingredient, including its name and calorie content.
 */
@Data
@AllArgsConstructor
public class IngredientDTO {
    private String foodName;
    private Double calories;
}
