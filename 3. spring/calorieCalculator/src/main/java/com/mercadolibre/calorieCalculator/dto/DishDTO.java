package com.mercadolibre.calorieCalculator.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Data Transfer Object (DTO) representing information about a dish, including its ingredients and calorie details.
 */
@Data
@AllArgsConstructor
public class DishDTO {
    private String name;
    private List<IngredientDTO> ingredients;
    private Double totalCalories;
    private IngredientDTO highestCalorieIngredient;
}
