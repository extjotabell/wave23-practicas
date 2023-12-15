package com.mercadolibre.caloriesCalculator.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


import com.mercadolibre.caloriesCalculator.entity.Ingredients;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IngredientsRepositoryImpl implements IIngredientsRepository {
    private List<Ingredients> ingredientsList = new ArrayList<>();

    public IngredientsRepositoryImpl() throws IOException {
        loadDataBase();
    }

    @Override
    public List<Ingredients> getAllIngredients() {
        return ingredientsList;
    }

    private void loadDataBase() throws IOException {
        File file;
        ObjectMapper objectMapper = new ObjectMapper();
        List<Ingredients> ingredients;

        file = ResourceUtils.getFile("classpath:food.json");
        ingredients = objectMapper.readValue(file, new TypeReference<List<Ingredients>>() {
        });

        ingredientsList = ingredients;
    }

}
