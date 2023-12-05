package org.example;

public class SerieDos extends Prototipo <Integer> {
    public SerieDos() {
        super(2);
    }

    @Override
    public Integer siguienteNumSerie() {
        int resultado = valorActual;
        valorActual += 2;
        return resultado;
    }
}
