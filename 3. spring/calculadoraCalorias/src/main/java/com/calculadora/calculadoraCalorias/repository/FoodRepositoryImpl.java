package com.calculadora.calculadoraCalorias.repository;


import com.calculadora.calculadoraCalorias.entity.Dish;
import com.calculadora.calculadoraCalorias.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepositoryImpl implements IFoodRepository {
    private List<Ingredient> ingredients;
    private List<Dish> dishes;

    public FoodRepositoryImpl() {
        this.ingredients = loadIngredients();
        this.dishes = loadDishes();
    }

    public List<Ingredient> loadIngredients() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {};
        List<Ingredient> ingredients = null;
        try {
            ingredients = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ingredients;
    }

    public List<Dish> loadDishes() {
        List<Ingredient> ingredientsDishOne = List.of(ingredients.get(11), ingredients.get(32), ingredients.get(50));
        Dish dishOne = new Dish("Pasta", ingredientsDishOne);

        List<Ingredient> ingredientsDishTwo = List.of(ingredients.get(34), ingredients.get(45), ingredients.get(61));
        Dish dishTwo = new Dish("Arroz con pollo", ingredientsDishTwo);

        List<Ingredient> ingredientsDishThree = List.of(ingredients.get(2), ingredients.get(65), ingredients.get(11));
        Dish dishThree = new Dish("Sopa de tomate", ingredientsDishThree);

        List<Dish> dishes = new ArrayList<>(List.of(dishOne, dishTwo, dishThree));

        return dishes;
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }
}
