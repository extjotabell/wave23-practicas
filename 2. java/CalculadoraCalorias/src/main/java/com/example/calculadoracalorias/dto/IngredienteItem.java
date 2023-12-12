package com.example.calculadoracalorias.dto;

public class IngredienteItem {
    private IngredienteDTO ingrediente;
    private double porcentajeCantidad;

    public IngredienteItem(IngredienteDTO ingrediente, double porcentajeCantidad) {
        this.ingrediente = ingrediente;
        this.porcentajeCantidad = porcentajeCantidad;
    }

    public IngredienteDTO getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(IngredienteDTO ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getPorcentajeCantidad() {
        return porcentajeCantidad;
    }

    public void setPorcentajeCantidad(double porcentajeCantidad) {
        this.porcentajeCantidad = porcentajeCantidad;
    }

    public double calcularCalorias(){
        return porcentajeCantidad*ingrediente.getCalories()/100;
    }
}
