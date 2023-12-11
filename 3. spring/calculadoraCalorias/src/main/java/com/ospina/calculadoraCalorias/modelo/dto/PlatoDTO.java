package com.ospina.calculadoraCalorias.modelo.dto;

import com.ospina.calculadoraCalorias.modelo.entidad.Ingrediente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PlatoDTO {
    private String nombre;
    private int totalCalorias;
    private ArrayList<Ingrediente> ingredientes;
    private Ingrediente ingredienteMasCalorico;

}
