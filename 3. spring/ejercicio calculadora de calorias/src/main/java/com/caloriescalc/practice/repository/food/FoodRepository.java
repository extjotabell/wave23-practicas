package com.caloriescalc.practice.repository.food;

import com.caloriescalc.practice.entity.Ingredient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class FoodRepository implements IFoodRepository {
    private static final String FILE_PATH = "/food.json";

    @Override
    public List<Ingredient> getAll() {
        try (InputStream inputStream = getClass().getResourceAsStream(FILE_PATH)) {
            return new ObjectMapper().readValue(inputStream, new TypeReference<List<Ingredient>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file at path: " + FILE_PATH, e);
        }
    }
}
