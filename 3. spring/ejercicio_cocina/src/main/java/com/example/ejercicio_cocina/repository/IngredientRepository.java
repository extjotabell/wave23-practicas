package com.example.ejercicio_cocina.repository;

import com.example.ejercicio_cocina.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository

public class IngredientRepository implements IIngredientRepository {

    private List<Ingredient> data = new ArrayList<>();
    @Override
    public List<Ingredient> getIngredient() {
        return data;
    }

    public IngredientRepository() throws IOException {
        loadData();
    }

    public void loadData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        data = objectMapper.readValue(new File("/Users/mlackington/Desktop/Ejercicios Java/ejercicio_cocina/src/main/java/com/example/ejercicio_cocina/repository/3. food.json"), new TypeReference<>() {
        });

    }
}
