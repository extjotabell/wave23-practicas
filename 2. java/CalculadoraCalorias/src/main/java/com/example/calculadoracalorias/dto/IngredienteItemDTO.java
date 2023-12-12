package com.example.calculadoracalorias.dto;

public class IngredienteItemDTO {
    private String nombre;
    private double gramos;
    private double calorias;

    public IngredienteItemDTO(String nombre, double gramos, double calorias) {
        this.nombre = nombre;
        this.gramos = gramos;
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
}
