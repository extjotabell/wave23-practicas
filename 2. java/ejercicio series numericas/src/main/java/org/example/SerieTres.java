package org.example;

public class SerieTres extends Prototipo <Integer> {
    public SerieTres() {
        super(3);
    }

    @Override
    public Integer siguienteNumSerie() {
        int resultado = valorActual;
        valorActual += 3;
        return resultado;
    }
}
