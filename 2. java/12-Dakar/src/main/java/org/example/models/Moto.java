package org.example.models;

public class Moto extends Vehiculo{
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300,2);
    }

    @Override
    public String toString() {
        return "Moto " + super.toString();
    }
}
