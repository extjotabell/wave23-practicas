package org.ejercicio.restaurante.service;

import org.ejercicio.restaurante.entity.Dish;
import org.ejercicio.restaurante.entity.DishDto;
import org.ejercicio.restaurante.entity.Ingredient;
import org.ejercicio.restaurante.entity.IngredientDto;
import org.ejercicio.restaurante.repository.IRestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;


@Service
public class RestaurantServiceImpl implements IRestaurantService {

    @Autowired
    IRestaurantRepository restaurantRepository;

    @Override
    public DishDto getAllInformationOfDishName(String dishName) {
        Dish dishAux = restaurantRepository.findDishByName(dishName);
        return new DishDto(dishAux.getName(), getTotalCalories(dishAux), dishAux.getIngredients(), getMaxCaloriesIngredient(dishAux));
    }

    private Double getTotalCalories(Dish dish) {
        return dish.getIngredients().stream()
                .mapToDouble(ingredient -> ingredient.getFood().getCalories() * ingredient.getWeight())
                .sum();
    }

    private IngredientDto getMaxCaloriesIngredient(Dish dish) {
        Ingredient ingredient = dish.getIngredients().stream()
                .max(Comparator.comparing(ingredient1 -> ingredient1.getFood().getCalories()))
                .orElse(null);
        return new IngredientDto(ingredient.getFood().getName(), ingredient.getFood().getCalories());
    }
}
