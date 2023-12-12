package com.example.ejercicio_cocina.dto;

import com.example.ejercicio_cocina.entity.Ingredient;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class DishDto {
    private String name;
    private List<Ingredient> ingredients;
    private Ingredient highCalorie;
}
