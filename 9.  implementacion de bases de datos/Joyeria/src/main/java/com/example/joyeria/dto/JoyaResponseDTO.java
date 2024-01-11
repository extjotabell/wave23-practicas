package com.example.joyeria.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JoyaResponseDTO {
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @JsonProperty("posee_piedra")
    private boolean poseePiedra;
    private boolean vendida;

    public JoyaResponseDTO(Long id, String nombre, String material, Double peso, String particularidad, boolean poseePiedra, boolean vendida) {
        this.id = id;
        this.nombre = nombre;
        this.material = material;
        this.peso = peso;
        this.particularidad = particularidad;
        this.poseePiedra = poseePiedra;
        this.vendida = vendida;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMaterial() {
        return material;
    }

    public Double getPeso() {
        return peso;
    }

    public String getParticularidad() {
        return particularidad;
    }

    public boolean isPoseePiedra() {
        return poseePiedra;
    }

    public boolean isVendida() {
        return vendida;
    }
}
