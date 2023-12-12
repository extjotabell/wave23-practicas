package com.mercadolibre.calculadoraCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Ingredientes {
    private String name;
    private Integer calories;
}
