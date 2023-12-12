package com.mercadolibre.calorieCalculator.service;

import com.mercadolibre.calorieCalculator.dto.DishDTO;

/**
 * Service interface for calculating calorie information related to dishes.
 */
public interface ICaloriesCalculatorService {
    /**
     * Calculates and retrieves the calorie information for a given dish.
     *
     * @param dishName The name of the dish for which to calculate calories.
     * @return A DishDTO containing the calculated information, or null if the dish is not found.
     */
    DishDTO calculateDishCalories(String dishName);
}
