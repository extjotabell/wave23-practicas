package com.spring.calorias.services;

import com.spring.calorias.dtos.DishDto;
import com.spring.calorias.dtos.IngredientDto;
import com.spring.calorias.model.Dish;
import com.spring.calorias.model.Food;
import com.spring.calorias.model.Ingredient;
import com.spring.calorias.repositories.IRestoRepository;
import com.spring.calorias.repositories.RestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DishServiceImpl implements IDishService{

    @Autowired
    private IRestoRepository restoRepository;
    @Override
    public DishDto getDishInfoByDishName(String dishName) {
        Dish dishAux = restoRepository.getDishByName(dishName);
        List<IngredientDto> ingredientDtos = dishAux.getIngredients().stream()
                .map(i-> {return new IngredientDto(i.getFood().getName(), i.getFood().getCalories());})
                .toList();

        return new DishDto(dishAux.getName(), getTotalCalories(dishAux), ingredientDtos, getMaxCaloriesIngredient(dishAux));
    }


    private Double getTotalCalories(Dish dish) {
        return dish.getIngredients().stream().mapToDouble(i->{
            return (i.getFood().getCalories());
        }).sum();
    }
    private IngredientDto getMaxCaloriesIngredient(Dish dish) {
        Ingredient ingredient =  dish.getIngredients().stream()
                .max(Comparator.comparing(i->i.getFood().getCalories()))
                .orElse(null);

        return new IngredientDto(ingredient.getFood().getName(), ingredient.getFood().getCalories());
    }



}
