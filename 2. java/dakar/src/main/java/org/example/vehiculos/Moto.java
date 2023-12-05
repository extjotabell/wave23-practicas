package org.example.vehiculos;

public class Moto extends Vehiculo {

    private static final int RUEDAS = 2;
    private static final int PESO = 1000;
    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setRuedas(RUEDAS);
        setPeso(PESO);
    }
}
