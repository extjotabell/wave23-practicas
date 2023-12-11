package com.example.calculadora_calorias.repository;

import com.example.calculadora_calorias.entity.Dish;
import com.example.calculadora_calorias.entity.Ingredient;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class DishesRepository implements com.example.calculadora_calorias.repository.Repository {
    private List<Dish> dishes;
    private List<Ingredient> ingredients;

    @Override
    public Optional<Dish> findByName(String findParam) {
        return dishes.stream().filter(dish -> dish.getName().equalsIgnoreCase(findParam)).findFirst();
    }

    @Override
    public List<Dish> findManyByName(List<String> findParams) {
        return dishes.stream().filter(dish -> findParams.contains(dish.getName().toLowerCase())).toList();
    }

    @PostConstruct
    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Ingredient[] ingredientsArray = objectMapper.readValue(
                new File("src/main/resources/static/food.json"), Ingredient[].class);
        ingredients = Arrays.asList(ingredientsArray);

        dishes = List.of(
                new Dish("Tacos", Arrays.asList(
                        findIngredient("aceitunas negras"),
                        findIngredient("apio"),
                        findIngredient("brócoli"),
                        findIngredient("lechuga"))
                ),
                new Dish("Ceviche", Arrays.asList(
                        findIngredient("perejil"),
                        findIngredient("pepino"),
                        findIngredient("pimiento")
                )),
                new Dish("Arepa", Arrays.asList(
                        findIngredient("harina de trigo refinada"),
                        findIngredient("queso crema")
                )),
                new Dish("Empanada", Arrays.asList(
                        findIngredient("harina de maíz"),
                        findIngredient("queso de bola")
                ))
        );
    }

    private Ingredient findIngredient(String name) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
