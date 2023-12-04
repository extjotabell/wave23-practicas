package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda campera1 = new Campera("Marca 1", "Modelo 1", "Campera 1","Negro");
        Prenda campera2 = new Campera("Marca 2", "Modelo 2","Campera 1", "Roja" );

        List<Prenda> prendas = List.of(campera1,campera2);

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);

        guardaRopa.mostrarPrendas();

        Prenda campera3 = new Campera("Marca 2", "Modelo 3", "Campera 3","Celeste");
        Prenda campera4 = new Campera("Marca 3", "Modelo 4","Campera 3", "Gris" );

        List<Prenda> prendas2 = List.of(campera3,campera4);
        guardaRopa.guardarPrendas(prendas2);
        guardaRopa.mostrarPrendas();

        guardaRopa.devolverPrendas(1);
    }
}