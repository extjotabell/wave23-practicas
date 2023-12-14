package com.caloriescalc.practice.service;

import com.caloriescalc.practice.dto.DishDTO;
import com.caloriescalc.practice.dto.DishesDTO;
import com.caloriescalc.practice.entity.Dish;
import com.caloriescalc.practice.entity.Ingredient;
import com.caloriescalc.practice.repository.dish.IDishRepository;
import com.caloriescalc.practice.request.RequestDish;
import com.caloriescalc.practice.request.RequestDishes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImp implements IRestaurantService {
    private final IDishRepository dr;

    public RestaurantServiceImp(IDishRepository dr) {
        this.dr = dr;
    }

    @Override
    public DishDTO getData(RequestDish requestDish) {
        try {
            Dish dish = dr.getByName(requestDish.getName());
            if (dish == null) {
                throw new Exception();
            }

            dish = multiplyByGrams(dish, requestDish.getWeigth());
            DishDTO dishDTO = new DishDTO();
            dishDTO.setName(dish.getName());
            dishDTO.setTotalCalories(dish.getCalories());
            dishDTO.setIngredients(dish.getIngredients());
            dishDTO.setIngredientWithMostCalories(ingredientWithMostCalories(dish));
            return  dishDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public DishesDTO getMultipleDishes(RequestDishes dishes) {
        try {
            List<Dish> allDishes = this.filterDishesByNames(dr.getAll(), dishes);
            List<DishDTO> dishesToReturn = new ArrayList<>();
            int[] weightsArray = dishes.getDishes().stream()
                    .mapToInt(RequestDish::getWeigth)
                    .toArray();

            if (allDishes.isEmpty()) {
                throw new Exception();
            }

            for (int i = 0; i < allDishes.size(); i++) {
                Dish d = allDishes.get(i);
                int weight = weightsArray[i];

                d = multiplyByGrams(d, weight);

                DishDTO dishDTO = new DishDTO();
                dishDTO.setName(d.getName());
                dishDTO.setTotalCalories(d.getCalories());
                dishDTO.setIngredients(d.getIngredients());
                dishDTO.setIngredientWithMostCalories(ingredientWithMostCalories(d));

                dishesToReturn.add(dishDTO);
            }

            return new DishesDTO(dishesToReturn);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Ingredient ingredientWithMostCalories(Dish dish) {
        Ingredient ingredient = null;

        for (Ingredient i : dish.getIngredients()) {
            if (ingredient == null) {
                ingredient = i;
            } else if (i.getCalories() > ingredient.getCalories()) {
                ingredient = i;
            }
        }

        return ingredient;
    }

    private Dish multiplyByGrams(Dish dish, int weigth) {
        Dish dishMultiplied = new Dish();
        dishMultiplied.setName(dish.getName());

        dishMultiplied.setIngredients(
                (ArrayList<Ingredient>) dish.getIngredients().stream().map(
                        ingredient -> {
                            Ingredient multipliedIngredient = new Ingredient();
                            multipliedIngredient.setName(ingredient.getName());
                            multipliedIngredient.setCalories(ingredient.getCalories() * weigth / 100);
                            return  multipliedIngredient;
                        }
                ).collect(Collectors.toList()));

        dishMultiplied.setCalories(dish.getCalories() * weigth / 100);

        return dishMultiplied;
    }

    public List<Dish> filterDishesByNames(List<Dish> allDishes, RequestDishes dishes) {
        List<String> dishNames = dishes.getDishes().stream()
                .map(RequestDish::getName)
                .toList();

        return allDishes.stream()
                .filter(d -> dishNames.contains(d.getName()))
                .sorted(Comparator.comparingInt(d -> dishNames.indexOf(d.getName())))
                .collect(Collectors.toList());
    }
}
