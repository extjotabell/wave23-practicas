package com.calculadora.calculadoraCalorias.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Ingredient {
    private String name;
    private int calories;
}
