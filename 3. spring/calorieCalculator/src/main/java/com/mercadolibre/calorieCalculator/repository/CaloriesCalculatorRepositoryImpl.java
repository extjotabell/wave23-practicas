package com.mercadolibre.calorieCalculator.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.calorieCalculator.entity.Dish;
import com.mercadolibre.calorieCalculator.entity.Food;
import com.mercadolibre.calorieCalculator.entity.Ingredient;
import com.mercadolibre.calorieCalculator.utils.exception.JsonReadException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Implementation of the {@link ICaloriesCalculatorRepository} interface that manages the retrieval of food and dish data.
 */
@Repository
public class CaloriesCalculatorRepositoryImpl implements ICaloriesCalculatorRepository {
    private final List<Dish> dishes = new ArrayList<>();
    private List<Food> foods = new ArrayList<>();

    /**
     * Initializes the repository simulating a database.
     */
    public CaloriesCalculatorRepositoryImpl(){
        loadFoodsFromJson();
        loadDishes();
    }

    /**
     * Retrieves a {@link Food} object by its name.
     *
     * @param name The name of the food to retrieve.
     * @return The Food object if found, otherwise null.
     */
    @Override
    public Food getFoodByName(String name) {
        return this.foods.stream().filter(food -> food.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    /**
     * Retrieves a {@link Dish} object by its name.
     *
     * @param dishName The name of the dish to retrieve.
     * @return The Dish object if found, otherwise null.
     */
    @Override
    public Dish getDishByName(String dishName) {
        return this.dishes.stream().filter(food -> food.getName().equalsIgnoreCase(dishName)).findFirst().orElse(null);
    }

    /**
     * Loads food data from a JSON file and populates the foods list.
     * @throws JsonReadException if there is an error reading the JSON file.
     */
    private void loadFoodsFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File file = new ClassPathResource("food.json").getFile();

            Food[] foodsArray = objectMapper.readValue(file, Food[].class);
            foods = Arrays.asList(foodsArray);
        } catch (IOException e) {
            e.printStackTrace();
            throw new JsonReadException("Error al leer el archivo JSON");
        }
    }

    /**
     * Initializes the dishes list with sample data.
     */
    private void loadDishes() {
        List<Ingredient> ingredientsPizza = new ArrayList<>();
        ingredientsPizza.add(createIngredient("Aceitunas verdes", 100.0));
        ingredientsPizza.add(createIngredient("Cebolla", 150.0));
        ingredientsPizza.add(createIngredient("Tomate triturado en conserva", 90.0));
        ingredientsPizza.add(createIngredient("Queso crema", 500.0));
        ingredientsPizza.add(createIngredient("Harina de trigo refinada", 1000.0));

        Dish dish1 = new Dish("Pizza", ingredientsPizza);
        dishes.add(dish1);
    }

    /**
     * Creates an Ingredient object using the provided food name and weight.
     * @param foodName The name of the food.
     * @param weight The weight of the ingredient.
     * @return The created Ingredient object.
     */
    private Ingredient createIngredient(String foodName, double weight) {
        Food food = getFoodByName(foodName);
        return new Ingredient(food, weight);
    }

}
