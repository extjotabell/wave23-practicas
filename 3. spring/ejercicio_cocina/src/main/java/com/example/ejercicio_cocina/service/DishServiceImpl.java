package com.example.ejercicio_cocina.service;

import com.example.ejercicio_cocina.dto.DishDto;
import com.example.ejercicio_cocina.dto.IngredientDto;
import com.example.ejercicio_cocina.entity.Dish;
import com.example.ejercicio_cocina.entity.Ingredient;
import com.example.ejercicio_cocina.repository.DishRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService{

    @Autowired
    DishRepositoryImpl repository;
    @Override
    public List<DishDto> getAllDishes(String variable) {
        List<DishDto> respuesta = new ArrayList<>();

        List<Dish> DishList = repository.getAllDishes().stream().filter(Dish -> Dish.getName().equals(variable)).toList();

        for (Dish aux: DishList
        ) {
            respuesta.add(new DishDto(aux.getName(),
                    aux.getIngredients(),
                    aux.getHighCalorie()));
        }

        return respuesta;
    }
}
