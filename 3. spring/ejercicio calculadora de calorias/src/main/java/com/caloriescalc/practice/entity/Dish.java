package com.caloriescalc.practice.entity;

import java.util.ArrayList;

public class Dish {
    private String name;
    private int calories;
    private ArrayList<Ingredient> ingredients = new ArrayList<>();

    public Dish() {
    }

    public Dish(String name, ArrayList<Ingredient> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = this.calculateCalories();
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    private int calculateCalories() {
        int total = 0;

        for (Ingredient i : ingredients) {
            total += i.getCalories();
        }

        return total;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", ingredients=" + ingredients +
                '}';
    }
}
