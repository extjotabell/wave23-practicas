package org.example;

import org.example.prendas.Camisa;
import org.example.prendas.Pantalon;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();

        int codCamisas = guardaRopa.guardarPrendas(List.of(
                new Camisa("Polo", "Polo blanca"), new Camisa("Polo", "Polo azul")));

        int codPantalon = guardaRopa.guardarPrendas(List.of(
                new Pantalon("Nike", "Nike blanco"), new Pantalon("Nike", "Nike azul")));

        System.out.println("---CAMISAS---");
        guardaRopa.devolverPrendas(codCamisas).forEach(System.out::println);
        System.out.println("---PANTALONES---");
        guardaRopa.devolverPrendas(codPantalon).forEach(System.out::println);
        System.out.println("---TODO EL GUARDAROPAS---");
        guardaRopa.mostrarPrendas();
    }
}