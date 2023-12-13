package com.pereiravilches.calculadoraDeCalorias.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Plato {
    private String nombre;
    private List<Ingrediente> ingredienteList;
}
