package com.mercadolibre.calorieCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents an ingredient, combining a type of food and its weight.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
    private Food food;
    private Double weight;
}
