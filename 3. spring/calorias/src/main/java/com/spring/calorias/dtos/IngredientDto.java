package com.spring.calorias.dtos;

import com.spring.calorias.model.Food;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class IngredientDto {
    private String foodName;
    private Double weight;
    private Double calories;
}
