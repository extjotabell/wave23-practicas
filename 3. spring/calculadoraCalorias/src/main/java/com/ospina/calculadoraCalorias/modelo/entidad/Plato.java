package com.ospina.calculadoraCalorias.modelo.entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Plato {
    private String nombre;
    private int totalCalorias;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombre, ArrayList<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.totalCalorias = calcularTotalCalorias();
    }

    private int calcularTotalCalorias() {
        int total = 0;
        for (Ingrediente ingrediente : ingredientes) {
            total += ingrediente.getCalorias();
        }
        return total;
    }
}
