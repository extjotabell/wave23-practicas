package com.spring.calculadoracalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Plato {
    private String nombre;
    Map<Ingrediente, Integer> ingredientes;
}
