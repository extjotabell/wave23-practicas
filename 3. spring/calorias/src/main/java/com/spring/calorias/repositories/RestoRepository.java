package com.spring.calorias.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calorias.model.Dish;
import com.spring.calorias.model.Food;
import com.spring.calorias.model.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class RestoRepository implements IRestoRepository{
    private static final String FILE_PATH = "src/main/resources/food.json";
    private final List<Food> foodDBList;
    private List<Dish> dishesDBList;

    public RestoRepository() {

        this.foodDBList = loadDataBase();
        this.dishesDBList = loadDishesData();
    }

    private List<Dish> loadDishesData() {
        List<Ingredient> ingredients = new ArrayList<>();
        Ingredient ingredient1 = new Ingredient(getFoodByName("Papas cocidas"), 150.0);
        Ingredient ingredient2 = new Ingredient(getFoodByName("Ternera"), 200.0);
        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        Dish dish1 = new Dish("Milanesa", ingredients);

        List<Dish> dishes  = new ArrayList<>();
        dishes.add(dish1);
        return dishes;
    }

    private List<Food> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Food>> typeRef = new TypeReference<>() {};
        List<Food> foods = null;
        try {
            foods= objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return foods;
    }
    public List<Food> getFoodList() {
        return foodDBList;
    }

    public Food getFoodByName(String name){
        return foodDBList.stream().filter(f->f.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

    @Override
    public Dish getDishByName(String name) {
        return dishesDBList.stream().filter(d->d.getName().equals(name)).findFirst().orElse(null);
    }

}