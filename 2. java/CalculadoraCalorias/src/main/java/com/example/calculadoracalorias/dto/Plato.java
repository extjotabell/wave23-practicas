package com.example.calculadoracalorias.dto;

import java.util.List;

public class Plato {
    private List<IngredienteItem> ingredientes;
    private String nombre;

    public Plato(List<IngredienteItem> ingredientes, String nombre) {
        this.ingredientes = ingredientes;
        this.nombre = nombre;
    }

    public List<IngredienteItem> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<IngredienteItem> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
