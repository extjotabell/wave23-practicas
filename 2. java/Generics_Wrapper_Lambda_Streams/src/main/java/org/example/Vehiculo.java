package org.example;

public class Vehiculo {
    //Ejercicio 1

    private String modelo;
    private String marca;
    private int costo;

    public Vehiculo(String modelo, String marca, int costo) {
        this.modelo = modelo;
        this.marca = marca;
        this.costo = costo;
    }


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

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehiculo: \n");
        sb.append("Modelo: ").append(modelo).append('\n');
        sb.append("Marca: ").append(marca).append('\n');
        sb.append("Costo: ").append(costo).append('\n');
        return sb.toString();
    }
}
