package org.vehiculos;

public class Moto extends Vehiculo {

    private static final int RUEDAS = 2, PESO = 300;

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        setRuedas(RUEDAS);
        setPeso(PESO);
    }
}
