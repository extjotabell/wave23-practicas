package com.mercadolibre.calorieCalculator.repository;

import com.mercadolibre.calorieCalculator.entity.Dish;
import com.mercadolibre.calorieCalculator.entity.Food;
import com.mercadolibre.calorieCalculator.entity.Ingredient;

import java.util.List;

/**
 * Repository interface for accessing dish and food data related to calorie calculation.
 */
public interface ICaloriesCalculatorRepository {

    /**
     * Retrieves a Dish object by its name.
     *
     * @param dishName The name of the dish to retrieve.
     * @return The Dish object if found, otherwise null.
     */
    Dish getDishByName(String dishName);
    /**
     * Retrieves a Food object by its name.
     *
     * @param name The name of the food to retrieve.
     * @return The Food object if found, otherwise null.
     */
    Food getFoodByName(String name);
}
