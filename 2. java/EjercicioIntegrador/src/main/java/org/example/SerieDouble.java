package org.example;

public class SerieDouble extends Prototipo<Double>{

    public SerieDouble(Double salto) {
        super(salto);
    }

    @Override
    protected Double siguienteNumero() {

        return super.valor_actual = valor_actual +2;
    }

    @Override
    protected void iniciarSerie(Double numero) {
         valor_inicial = numero % 2;
         reiniciarSerie();
    }

    @Override
    protected void reiniciarSerie() {
        valor_actual = valor_inicial;

    }
}
