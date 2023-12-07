package org.example;

public abstract class Prototipo<T> {
    protected T valorInicial;
    protected T valorActual;
    protected T contador;

    public Prototipo(T contador) {
        this.contador = contador;
    }

    //1 - metodo para devolver un numero que corresponde al siguiente valor en la serie progresiva
    public T valorSiguiente(){
        T valorSiguienteVar = valorActual;
        valorActual = generarActual(valorActual, contador);
        return valorSiguienteVar;
    };

    //2 - metodo que reinicia la serie
    public void valorReiniciar() {
        valorActual = valorInicial;
    }

    //3 - para establecer el valor inicial de la serie
    public void establecerValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
        valorActual = this.valorInicial;
    }

    public abstract T generarActual (T a, T b);

}
