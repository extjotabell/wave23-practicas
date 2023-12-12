package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.entity.Dish;
import com.spring.calculadoracalorias.entity.Ingredient;
import com.spring.calculadoracalorias.repository.interfaces.IDishRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepositoryImpl implements IDishRepository {

    List<Dish> dishes;

    public DishRepositoryImpl() {
        dishes = loadPlatos();
    }

    @Override
    public Dish getDishByName(String name) {

        Optional<Dish> first = dishes.stream().filter(x -> x.getName().equals(name)).findFirst();
        Dish dish = null;

        if (first.isPresent()) {
            dish = first.get();
        }
        return dish;
    }


    private List<Dish> loadPlatos() {
        return List.of(new Dish("Plato 1", List.of("Queso fundido untable", "Alcachofas", "Aceitunas negras")),
                new Dish("Plato 2", List.of("Cebolla", "Espinaca", "Hinojo")));
    }
}
