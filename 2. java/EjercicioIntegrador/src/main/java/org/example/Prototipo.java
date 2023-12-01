package org.example;

public abstract class Prototipo <N extends Number> {
    N valor_actual;
    N valor_inicial;
    N salto;

    public Prototipo(N salto) {
        this.salto = salto;
        iniciarSerie(salto);
    }

    protected abstract N siguienteNumero();

    protected abstract void iniciarSerie(N numero);

    protected abstract void reiniciarSerie();


}
