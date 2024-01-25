package com.spring.calculadoracalorias.repository;

import com.spring.calculadoracalorias.entity.Dish;
import com.spring.calculadoracalorias.entity.Ingredient;
import com.spring.calculadoracalorias.repository.interfaces.IDishRepository;
import com.spring.calculadoracalorias.repository.interfaces.IIngredientRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DishRepositoryImpl implements IDishRepository {

    List<Dish> dishes;
    IIngredientRepository ingredientRepository = new IngredientRepositoryImpl();;

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
        return List.of(
                new Dish("Ensalada",
                    List.of(
                            ingredientRepository.getIngredientByName("Lechuga"),
                            ingredientRepository.getIngredientByName("Nueces"),
                            ingredientRepository.getIngredientByName("Aceitunas negras")
                    )
                ),
                new Dish("Pico_de_Gallo",
                    List.of(
                            ingredientRepository.getIngredientByName("Cebolla"),
                            ingredientRepository.getIngredientByName("Vinagres"),
                            ingredientRepository.getIngredientByName("Tomates")
                    )
                )
        );
    }
}
