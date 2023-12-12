package com.mercadolibre.calculadoraCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes;
}
