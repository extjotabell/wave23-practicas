package com.example.ejercicio_cocina.entity;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Dish {
    private String name;
    private List<Ingredient> ingredients;
    private Ingredient highCalorie;
}
