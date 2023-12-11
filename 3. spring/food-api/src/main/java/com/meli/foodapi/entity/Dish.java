package com.meli.foodapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dish {
    private String name;
    private List<Ingredient> ingredients;
    //Standar: 200 gr
    //private int weight = 200;
}
