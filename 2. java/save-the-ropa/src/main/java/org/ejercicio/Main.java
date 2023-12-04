package org.ejercicio;

import org.ejercicio.modelo.Camisa;
import org.ejercicio.modelo.GuardaRopa;
import org.ejercicio.modelo.Prenda;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Prenda camisaUno = new Camisa("H&M", "Modelo 2023");
        Prenda pantalonUno = new Camisa("H&M", "Modelo 2020");
        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarRopa(List.of(camisaUno,pantalonUno));


        Prenda camisaDos = new Camisa("Pepito", "Modelo 2000");
        Prenda pantalonDos = new Camisa("Pepito", "Modelo 2011");
        guardaRopa.guardarRopa(List.of(camisaDos, pantalonDos));

        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(1);

        System.out.println("Despues de borrar");
        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(10);


    }
}