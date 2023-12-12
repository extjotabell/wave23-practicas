package com.spring.calorias.services;

import com.spring.calorias.dtos.DishDto;
import com.spring.calorias.dtos.IngredientDto;
import com.spring.calorias.dtos.RequestDishDto;
import com.spring.calorias.model.Dish;
import com.spring.calorias.model.Food;
import com.spring.calorias.model.Ingredient;
import com.spring.calorias.repositories.IRestoRepository;
import com.spring.calorias.repositories.RestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class DishServiceImpl implements IDishService{

    @Autowired
    private IRestoRepository restoRepository;
    @Override
    public DishDto getDishInfoByDishName(String dishName) {
        Dish dishAux = restoRepository.getDishByName(dishName);
        if(dishAux == null){return null;}

        return new DishDto(dishAux.getName(), getTotalCalories(dishAux),
                    getDishFormerWeight(dishAux), getIngredientsDtoByDish(dishAux),
                    getMaxCaloriesIngredient(dishAux));
    }

    @Override
    public DishDto getDishInfoByDishNameAndWeight(String dishName, Double dishWeight) {
        Dish dishAux = restoRepository.getDishByName(dishName);
        if(dishAux == null){return null;}

        dishAux.setIngredients(getIngredientsWithNewWeight(dishAux, dishWeight));
        return new DishDto(dishAux.getName(), getTotalCaloriesByDishWeight(dishAux, dishWeight),
                dishWeight, getIngredientsDtoByDish(dishAux),
                getMaxCaloriesIngredient(dishAux));
    }

    @Override
    public List<DishDto> getDishesInfoByDishesNames(List<RequestDishDto> dishes) {
        return dishes.stream()
                .map(d->getDishInfoByDishName(d.getDishName()))
                .filter(Objects::nonNull)
                .toList();
    }

    public List<Ingredient> getIngredientsWithNewWeight(Dish dish, Double dishWeight){
        Double growthIndex = dishWeight / getDishFormerWeight(dish);
        return dish.getIngredients().stream().peek(i-> i.setWeight(
                        (double) Math.round(growthIndex * i.getWeight()) ))
                .toList();

    }
    private List<IngredientDto> getIngredientsDtoByDish(Dish dish){
        return dish.getIngredients().stream()
                .map(i-> new IngredientDto(i.getFood().getName(), i.getWeight(), getCaloriesByIngredient(i)))
                .toList();
    }
    private Double getTotalCaloriesByDishWeight(Dish dish, Double newDishWeight) {
        return (double) Math.round(newDishWeight * (getTotalCalories(dish)) / getDishFormerWeight(dish));

    }

    private Double getDishFormerWeight(Dish dish) {
        return dish.getIngredients()
                .stream()
                .mapToDouble(Ingredient::getWeight)
                .sum();
    }

    private Double getTotalCalories(Dish dish) {
        return dish.getIngredients()
                .stream()
                .mapToDouble(this::getCaloriesByIngredient)
                .sum();
    }

    private IngredientDto getMaxCaloriesIngredient(Dish dish) {
        Ingredient ingredient =  dish.getIngredients().stream()
                .max(Comparator.comparing(this::getCaloriesByIngredient))
                .orElse(null);

        return new IngredientDto(ingredient.getFood().getName(), ingredient.getWeight(),
                getCaloriesByIngredient(ingredient));
    }

    private Double getCaloriesByIngredient(Ingredient ing){
        return ing.getWeight() * ing.getFood().getCalories() / 100;
    }
}
