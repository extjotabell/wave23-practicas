package org.ejercicio.model;

public abstract class Serie <T extends Number>{
    T valorInicial;
    T valorActual;

    public Serie(){}

    public Serie(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract T valorSiguiente();
    public void reiniciarSerie(){
        System.out.println("Se reinicia la serie.");
        valorActual = valorInicial;
    }

    public void setValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
    }

    public T getValorInicial(){
        return valorInicial;
    }

    public void mostrarRango(int longiud){
        System.out.println(getValorInicial());
        for(int i = 1; i< longiud; i++ ){
            System.out.println(valorSiguiente());
        }
    }
}
