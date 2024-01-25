package com.spring.calculadoracalorias.dto;

import com.spring.calculadoracalorias.entity.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private int totalCalories;
    private List<IngredientDto> ingredients;
    private String highestCalorieIngredient;
}
