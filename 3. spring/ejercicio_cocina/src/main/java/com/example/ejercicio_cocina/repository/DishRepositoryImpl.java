package com.example.ejercicio_cocina.repository;

import com.example.ejercicio_cocina.entity.Dish;
import com.example.ejercicio_cocina.entity.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class DishRepositoryImpl implements IDishRepository{


    IngredientRepository repository = new IngredientRepository();

    private List<Dish> data = new ArrayList<>();
    private List<Ingredient> ingredients = repository.getIngredient();

    public DishRepositoryImpl() throws IOException {
        loadDataDishes();
    }

    public void loadDataDishes(){

        List<Ingredient> aux = Arrays.asList(ingredients.stream().filter(ingredient -> ingredient.getName().equals("Apio")).findAny().get(),
                ingredients.stream().filter(ingredient -> ingredient.getName().equals("Ajos")).findAny().get(),
                ingredients.stream().filter(ingredient -> ingredient.getName().equals("Cebolla")).findAny().get());

        data.add(new Dish("Ensalada", aux,
                aux.stream().max(Comparator.comparingInt(Ingredient::getCalories)).orElseThrow()));
    }
    @Override
    public List<Dish> getAllDishes() {
        return data;
    }
}
