package com.example.joyeria.model;

import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.ConstructorBinding;

@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    private boolean vendida;

    public Joya() {}

    public Joya(String nombre, String material, Double peso, String particularidad, boolean poseePiedra, boolean vendida) {
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

    public void setVendida(boolean vendida) { this.vendida = vendida; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setParticularidad(String particularidad) {
        this.particularidad = particularidad;
    }

    public void setPoseePiedra(boolean poseePiedra) {
        this.poseePiedra = poseePiedra;
    }
}
