package com.covid.sintomas.DTOS;

public class SintomaDTO {
    private String nombre;
    private String gravedad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public SintomaDTO(String nombre, String gravedad) {
        this.nombre = nombre;
        this.gravedad = gravedad;
    }
}
