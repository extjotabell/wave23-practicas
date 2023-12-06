package org.test;

import org.bootcamp.Doble;
import org.bootcamp.Entero;
import org.bootcamp.Prototipo;

public class Main {

    public static void main(String[] args){
        Prototipo entero = new Entero(0, 2);

        System.out.println("Entero");
        entero.devuelveValor();
        entero.devuelveValor();
        entero.devuelveValor();
        entero.reinicioSerie();
        entero.devuelveValor();
        entero.devuelveValor();

        entero.estableceInicial(1);
        entero.devuelveValor();
        entero.devuelveValor();
        entero.devuelveValor();
        entero.devuelveValor();

        System.out.println();

        System.out.println("Doble");
        Prototipo doble = new Doble(0.0, 1.5);
        doble.devuelveValor();
        doble.devuelveValor();
        doble.devuelveValor();
        doble.devuelveValor();
        doble.estableceInicial(5.1934);
        doble.devuelveValor();
        doble.devuelveValor();
        doble.reinicioSerie();
        doble.devuelveValor();
    }

}
