package org.example;

public class SerieEnteros extends Prototipo<Integer>{

    public SerieEnteros(Integer salto) {
        super(salto);
    }

    @Override
    protected Integer siguienteNumero() {
        return super.valor_actual = valor_actual +2;
    }

    @Override
    protected void iniciarSerie(Integer numero) {
         valor_inicial =  numero % 2;
         reiniciarSerie();
    }

    @Override
    protected void reiniciarSerie() {
        valor_actual = valor_inicial;

    }
}
