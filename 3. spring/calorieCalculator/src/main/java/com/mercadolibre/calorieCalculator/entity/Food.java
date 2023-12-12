package com.mercadolibre.calorieCalculator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a type of food, containing a name and its caloric value.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    private String name;
    private Double calories;
}
