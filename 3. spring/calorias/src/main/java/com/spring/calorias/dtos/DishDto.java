package com.spring.calorias.dtos;

import com.spring.calorias.model.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class DishDto {
    private String dishName;
    private Double totalCalories;
    private Double dishWeight;
    private List<IngredientDto> ingredientsDto;
    private IngredientDto maxCaloriesIngredient;
}
