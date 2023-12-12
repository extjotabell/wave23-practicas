package com.spring.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Dish {
    private String name;
    List<String> ingredients;
}
