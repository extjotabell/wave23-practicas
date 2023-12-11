package com.spring.calculadoracalorias.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Ingrediente {
    @JsonProperty("name")
    private String nombre;
    @JsonProperty("calories")
    private int calorias;
}
