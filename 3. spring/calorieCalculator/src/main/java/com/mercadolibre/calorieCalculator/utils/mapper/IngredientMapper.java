package com.mercadolibre.calorieCalculator.utils.mapper;

import com.mercadolibre.calorieCalculator.dto.IngredientDTO;
import com.mercadolibre.calorieCalculator.entity.Ingredient;

/**
 * Utility class for mapping Ingredient entities to IngredientDTOs.
 */
public class IngredientMapper {

    /**
     * Maps an Ingredient entity to an IngredientDTO.
     *
     * @param ingredient The Ingredient entity to be mapped.
     * @return An IngredientDTO representing the mapped information.
     */
    public static IngredientDTO mapToIngredientDTO(Ingredient ingredient) {
        return new IngredientDTO(ingredient.getFood().getName(), ingredient.getFood().getCalories());
    }
}
