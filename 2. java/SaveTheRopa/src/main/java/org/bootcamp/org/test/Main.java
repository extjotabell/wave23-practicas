package org.bootcamp.org.test;

import org.bootcamp.GuardaRopa;
import org.bootcamp.Pantalon;
import org.bootcamp.Remera;

import java.util.List;

public class Main {

    public static void main(String[] args){
        GuardaRopa guardaRopa = new GuardaRopa();

        int codigoRemera = guardaRopa.guardarPrendas(List.of(new Remera(1, "Lacoste", "Blanco"),
        (new Remera(2, "Puma", "Run Fit")), new Remera(3, "Generica", "Verde")));

        int codigoPantalon = guardaRopa.guardarPrendas(List.of(new Pantalon(1, "Adidas", "Polar Negro")));

        System.out.println("Todas las Remeras");
        guardaRopa.devolverPrendas(codigoRemera).stream().forEach(System.out::println);

        System.out.println("Todas las prendas.");
        guardaRopa.mostrarPrendas();
    }

}
