package com.meli.foodapi.repository.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.foodapi.entity.Dish;
import com.meli.foodapi.entity.Ingredient;
import com.meli.foodapi.repository.IFoodRepository;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {

    private List<Ingredient> ingredients;
    private List<Dish> dishes;


    public FoodRepository(){
        loadData();
    }

    @Override
    public List<Ingredient> getAllIngredients() {
        return ingredients;
    }

    @Override
    public List<Dish> getAllDishes() {
        return dishes;
    }

    private void loadData(){
        ingredients = new ArrayList<>();
        dishes = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/static/food.json"));
            ObjectMapper objectMapper = new ObjectMapper();

            List<Ingredient> listFromJson = objectMapper.readValue(reader,
                    objectMapper.getTypeFactory().constructCollectionType(List.class, Ingredient.class));

            listFromJson.stream().forEach(c -> ingredients.add(c));

            loadDishes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadDishes(){
        List<Ingredient> ingredientsDishOne = List.of(ingredients.get(0),ingredients.get(32), ingredients.get(50));


        Dish dishOne = new Dish("Pasta", ingredientsDishOne);

        List<Ingredient> ingredientsDishTwo = List.of(ingredients.get(34),ingredients.get(45), ingredients.get(61));
        Dish dishTwo = new Dish("Arroz con pollo", ingredientsDishTwo);

        List<Ingredient> ingredientsDishThree = List.of(ingredients.get(2),ingredients.get(65), ingredients.get(11));
        Dish dishThree = new Dish("Sopa de tomate", ingredientsDishThree);

        dishes.addAll(List.of(dishOne, dishTwo, dishThree));

    }
}
