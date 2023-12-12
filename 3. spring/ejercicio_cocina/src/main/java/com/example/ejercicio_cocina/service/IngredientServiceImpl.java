package com.example.ejercicio_cocina.service;

import com.example.ejercicio_cocina.dto.IngredientDto;
import com.example.ejercicio_cocina.entity.Ingredient;
import com.example.ejercicio_cocina.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class IngredientServiceImpl implements IIngredientService {

    @Autowired
    IngredientRepository repository;
    @Override
    public List<IngredientDto> getIngredient(String variable) {
        List<IngredientDto> respuesta = new ArrayList<>();

        List<Ingredient> ingredientList = repository.getIngredient();

        List<Ingredient> filtrada = ingredientList.stream().filter(ingredient ->
                ingredient.getName().contains(variable)
        ).toList();

        for (Ingredient aux: filtrada
        ) {
            respuesta.add(new IngredientDto(aux.getName(),
                    aux.getCalories()));
        }

        return respuesta;
    }
}
