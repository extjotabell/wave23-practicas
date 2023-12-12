package com.spring.calculadoracalorias.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDto {
    private int totalCalories;
    private List<String> ingredients;
    private String highestCalorieIngredient;
}
