package com.example.CalculadoraCalorias.entity;

public class Ingredient {
    private String name;
    private Double calories;

    public String getName() {
        return name;
    }

    public Double getCalories() {
        return calories;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }
}
