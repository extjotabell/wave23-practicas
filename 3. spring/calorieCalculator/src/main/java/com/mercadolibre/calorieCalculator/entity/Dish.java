package com.mercadolibre.calorieCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a dish, which consists of a name and a list of ingredients.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
}
