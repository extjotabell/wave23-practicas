package org.example;

public class Vehiculos {
    private String modelo;
    private String marca;
    private double costo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public Vehiculos(String modelo, String marca, double costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }
}
