package com.calculadoraCalorias.calculadoraCalorias.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Plato {
    private String name;
    private List<Ingrediente> ingredients;

}
