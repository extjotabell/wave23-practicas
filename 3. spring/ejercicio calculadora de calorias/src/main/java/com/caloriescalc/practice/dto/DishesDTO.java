package com.caloriescalc.practice.dto;

import java.util.ArrayList;
import java.util.List;

public class DishesDTO {
    List<DishDTO> dishes = new ArrayList<>();

    public DishesDTO(List<DishDTO> dishes) {
        this.dishes = dishes;
    }

    public List<DishDTO> getDishes() {
        return dishes;
    }

    public void setDishes(List<DishDTO> dishes) {
        this.dishes = dishes;
    }
}
