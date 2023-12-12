package com.spring.calculadoracalorias.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.calculadoracalorias.entity.Ingredient;
import com.spring.calculadoracalorias.repository.interfaces.IIngredientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredientRepositoryImpl implements IIngredientRepository {


    public List<Ingredient> ingredientList;

    public IngredientRepositoryImpl() {
        ingredientList = loadIngredients();
    }

    @Override
    public Ingredient getIngredientByName(String name) {
        Optional<Ingredient> ingredient =
                ingredientList.stream()
                        .filter(i -> i.getName().equals(name))
                        .findFirst();

        Ingredient response = null;
        if (ingredient.isPresent()) {
            response = ingredient.get();
        }
        return response;
    }

    private List<Ingredient> loadIngredients() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:food.json");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Ingredient>> typeRef = new TypeReference<>() {
        };
        List<Ingredient> ingredients = null;

        try {
            ingredients = mapper.readValue(file, typeRef);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return ingredients;
    }
}
