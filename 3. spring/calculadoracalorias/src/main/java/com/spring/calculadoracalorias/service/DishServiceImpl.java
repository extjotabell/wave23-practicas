package com.spring.calculadoracalorias.service;

import com.spring.calculadoracalorias.dto.DishDto;
import com.spring.calculadoracalorias.dto.IngredientDto;
import com.spring.calculadoracalorias.entity.Dish;
import com.spring.calculadoracalorias.entity.Ingredient;
import com.spring.calculadoracalorias.repository.DishRepositoryImpl;
import com.spring.calculadoracalorias.repository.IngredientRepositoryImpl;
import com.spring.calculadoracalorias.service.interfaces.IDishService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Objects;

@Service
public class DishServiceImpl implements IDishService {

    private final IngredientRepositoryImpl ingredientRepository;
    private final DishRepositoryImpl dishRepository;

    public DishServiceImpl(IngredientRepositoryImpl repository, DishRepositoryImpl dishRepository) {
        ingredientRepository = repository;
        this.dishRepository = dishRepository;
    }

    @Override
    public DishDto caloricReport(String name, int grams) {
        DishDto dishDto = new DishDto();
        Dish dish = getDish(name);
        dishDto.setTotalCalories(totalCalories(dish));
        dishDto.setIngredients(dish.getIngredients().stream().map(ingredient -> new IngredientDto(ingredient.getName(), ingredient.getCalories())).toList());
        dishDto.setHighestCalorieIngredient(getHighestCalorieIngredient(dish));
        return dishDto;
    }

    private Dish getDish(String name) {
        return dishRepository.getDishByName(name);
    }

    private String getHighestCalorieIngredient(Dish dish) {
        return dish.getIngredients().stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(Ingredient::getCalories))
                .map(Ingredient::getName)
                .orElse("");
    }

    private int totalCalories(Dish dish) {
        return dish
                .getIngredients()
                .stream()
                .mapToInt(Ingredient::getCalories)
                .sum();
    }
}