package com.caloriescalc.practice.request;

import java.util.ArrayList;
import java.util.List;

public class RequestDishes {
    private List<RequestDish> dishes;

    public RequestDishes() {
    }

    public RequestDishes(List<RequestDish> dishes) {
        this.dishes = dishes;
    }

    public List<RequestDish> getDishes() {
        return dishes;
    }

    public void setDishes(List<RequestDish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        return "RequestDishes{" +
                "dishes=" + dishes +
                '}';
    }
}
