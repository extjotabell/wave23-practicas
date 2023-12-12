package com.calculadoraCalorias.calculadoraCalorias.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ingrediente {
    private String name;
    private int calories;
}
