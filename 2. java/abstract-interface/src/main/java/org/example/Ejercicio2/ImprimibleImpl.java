package org.example.Ejercicio2;

public class ImprimibleImpl<T> implements Imprimible<T>{
    @Override
    public void imprimir(T documento) {
        System.out.println(documento);
    }
}
