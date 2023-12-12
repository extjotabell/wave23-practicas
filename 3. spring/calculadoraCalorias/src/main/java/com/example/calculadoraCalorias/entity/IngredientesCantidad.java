package com.example.calculadoraCalorias.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class IngredientesCantidad {

    private String nombre;
    private int cantidad;
}
