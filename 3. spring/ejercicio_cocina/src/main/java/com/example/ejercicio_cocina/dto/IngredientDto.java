package com.example.ejercicio_cocina.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class IngredientDto {
    private String name;
    private int calories;
}
