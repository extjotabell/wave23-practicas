package org.example.Dakar.Clases;

public abstract class Vehiculo {
    private double velocidad, aceleracion, anguloDeGiro, peso;
    private String patente;
    private int ruedas;

    public double getVelocidad() {
        return velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public double getPeso() {
        return peso;
    }

    public String getPatente() {
        return patente;
    }

    public int getRuedas() {
        return ruedas;
    }

    public Vehiculo(double velocidad, double aceleracion, double anguloDeGiro, double peso, String patente, int ruedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.patente = patente;
        this.ruedas = ruedas;
    }
}
