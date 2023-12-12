package org.ejercicio.restaurante.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DishDto {
    private String dishName;
    private Double totalCalories;
    private List<Ingredient> ingredientList;
    private IngredientDto ingredientBigCalory;

}
