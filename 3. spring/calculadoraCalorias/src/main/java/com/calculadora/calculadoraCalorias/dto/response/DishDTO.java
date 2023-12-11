package com.calculadora.calculadoraCalorias.dto.response;

import com.calculadora.calculadoraCalorias.entity.Ingredient;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class DishDTO {
    private String name;
    private int weight;
    private List<IngredientDTO> ingredients;
    private IngredientDTO highIngredient;
}
