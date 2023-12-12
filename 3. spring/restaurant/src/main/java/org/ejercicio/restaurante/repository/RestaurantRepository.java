package org.ejercicio.restaurante.repository;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ejercicio.restaurante.entity.Dish;
import org.ejercicio.restaurante.entity.Food;
import org.ejercicio.restaurante.entity.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository implements IRestaurantRepository {

    private List<Dish> dishesDb;
    private List<Food> foodDb;

    public RestaurantRepository() {
        System.out.printf("------------ PASO 1 ---------------");
        this.foodDb = loadFoodDataBase();
        this.dishesDb = loadDishesDataBase();
        System.out.printf("------------ PASO 2 ---------------");
    }

    private List<Food> loadFoodDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Food>> typeRef = new TypeReference<>() {
        };
        List<Food> foods = null;
        try {
            foods = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }

    private List<Dish> loadDishesDataBase() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(getFoodByName("Papas cocidas"), 150.0);
        Ingredient ingredient2 = new Ingredient(getFoodByName("Ternera"), 200.0);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        Dish dish1 = new Dish("Milanesa", ingredients);

        List<Dish> dishes = new ArrayList<>();
        dishes.add(dish1);
        return dishes;
    }

    public Food getFoodByName(String foodName) {
        return this.foodDb.stream().filter(food -> food.getName().equalsIgnoreCase(foodName)).findFirst().orElse(null);
    }

    @Override
    public Dish findDishByName(String dishName) {
        return this.dishesDb.stream().filter(food -> food.getName().equalsIgnoreCase(dishName)).findFirst().orElse(null);
    }
}
