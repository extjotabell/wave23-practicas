package org.example;

import org.example.modelo.GuardaRopa;
import org.example.modelo.Prenda;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Crear prendas
        Prenda prenda1 = new Prenda("Nike", "Camiseta");
        Prenda prenda2 = new Prenda("Adidas", "Pantalón");

        // Crear guardarropa
        GuardaRopa guardaRopa = new GuardaRopa();

        // Guardar prendas y obtener el número identificador
        Integer numeroIdentificador = guardaRopa.guardarPrendas(List.of(prenda1, prenda2));

        // Mostrar las prendas en el guardarropa
        System.out.println("Prendas en el guardarropa:");
        guardaRopa.mostrarPrendas();

        // Consultar las prendas guardadas bajo el número identificador
        List<Prenda> prendasRecuperadas = guardaRopa.devolverPrendas(numeroIdentificador);

        // Imprimir las prendas recuperadas
        System.out.println("\nPrendas recuperadas:");
        for (Prenda prenda : prendasRecuperadas) {
            System.out.println("Marca: " + prenda.getMarca() + ", Modelo: " + prenda.getModelo());
        }
    }
}
