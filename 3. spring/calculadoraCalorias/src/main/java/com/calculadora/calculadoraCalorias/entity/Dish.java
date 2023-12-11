package com.calculadora.calculadoraCalorias.entity;

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
}
