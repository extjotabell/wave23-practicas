package org.example.vehiculos;

public class Auto extends Vehiculo {

    private static final int RUEDAS = 4;
    private static final int PESO = 1000;

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setRuedas(RUEDAS);
        setPeso(PESO);
    }
}
