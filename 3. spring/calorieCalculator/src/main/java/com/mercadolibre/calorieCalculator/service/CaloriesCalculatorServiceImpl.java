package com.mercadolibre.calorieCalculator.service;

import com.mercadolibre.calorieCalculator.dto.DishDTO;
import com.mercadolibre.calorieCalculator.dto.IngredientDTO;
import com.mercadolibre.calorieCalculator.entity.Dish;
import com.mercadolibre.calorieCalculator.entity.Ingredient;
import com.mercadolibre.calorieCalculator.utils.mapper.IngredientMapper;
import com.mercadolibre.calorieCalculator.repository.ICaloriesCalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for calculating calorie information related to dishes.
 */
@Service
public class CaloriesCalculatorServiceImpl implements ICaloriesCalculatorService {

    @Autowired
    private ICaloriesCalculatorRepository repository;

    /**
     * Calculates and retrieves the calorie information for a given dish.
     *
     * @param dishName The name of the dish for which to calculate calories.
     * @return A DishDTO containing the calculated information, or null if the dish is not found.
     */
    @Override
    public DishDTO calculateDishCalories(String dishName) {
        Dish dish = repository.getDishByName(dishName);

        if (dish == null || dish.getIngredients() == null) {
            return null;
        }

        List<IngredientDTO> ingredientsList = dish.getIngredients().stream()
                .map(IngredientMapper::mapToIngredientDTO)
                .collect(Collectors.toList());

        return new DishDTO(dish.getName(), ingredientsList, calculateTotalCalories(dish), getMaxCaloriesIngredient(dish));
    }

    /**
     * Calculates the total calories for a given dish.
     *
     * @param dish The dish for which to calculate total calories.
     * @return The total calories for the dish.
     */
    private Double calculateTotalCalories(Dish dish) {
        return dish.getIngredients().stream()
                .mapToDouble(ingredient -> ingredient.getFood().getCalories() * ingredient.getWeight()).sum();
    }

    /**
     * Retrieves the ingredient with the highest calories for a given dish.
     *
     * @param dish The dish for which to find the ingredient with the highest calories.
     * @return An IngredientDTO representing the ingredient with the highest calories.
     */
    private IngredientDTO getMaxCaloriesIngredient(Dish dish) {
        Ingredient ingredient = dish.getIngredients().stream()
                .max(Comparator.comparing(ingredient1 -> ingredient1.getFood().getCalories()))
                .orElse(null);

        assert ingredient != null;
        return IngredientMapper.mapToIngredientDTO(ingredient);
    }
}