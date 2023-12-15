package com.mercadolibre.caloriesCalculator.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mercadolibre.caloriesCalculator.entity.Ingredients;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DishesDTO {
    private String nameDishes;
    List<Ingredients> ingredientsList;
    Ingredients ingredientsWithMoreCalories;

    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    Integer totalCalories;
}
