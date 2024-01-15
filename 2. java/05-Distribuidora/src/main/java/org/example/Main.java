package org.example;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Creamos la lista de productos
        List<Producto> productos = new ArrayList<>();

        // Rellenamos la lista con almenos 10 productos.
        productos.add(new Perecedero("Arroz", 80.00, 5));
        productos.add(new Perecedero("Pan", 80.00, 2));
        productos.add(new NoPerecedero("Jabon", 80.00, "Perfumería"));
        productos.add(new NoPerecedero("Shampoo", 80.00, "Perfumería"));
        productos.add(new Perecedero("Leche", 80.00, 1));
        productos.add(new Perecedero("Carne", 80.00, 3));
        productos.add(new Perecedero("Pollo", 80.00, 4));
        productos.add(new NoPerecedero("Acondicionador", 80.00, "Perfumería"));
        productos.add(new NoPerecedero("Algodon", 80.00, "Perfumería"));
        productos.add(new NoPerecedero("Pasta de dientes", 80.00, "Perfumería"));;
        // Creamos dos nuevas listas para cada uno de los tipos de productos

        List<Perecedero> ProductosPerecederos = new ArrayList<>();
        List<NoPerecedero> ProductosNoPerecederos = new ArrayList<>();

        for (Producto p : productos) {
            if (p instanceof Perecedero) {
                ProductosPerecederos.add((Perecedero) p);
            } else if (p instanceof NoPerecedero) {
                ProductosNoPerecederos.add((NoPerecedero) p);
            }
        }

        double precioPerecederos = 0;
        double precioNoPerecederos = 0;

        if(ProductosPerecederos.size() >= 5){
            for (Perecedero p: ProductosPerecederos){
                precioPerecederos += p.calcular(2);
            }
        }

        if(ProductosNoPerecederos.size() >= 5){
            for (NoPerecedero p: ProductosNoPerecederos){
                precioNoPerecederos += p.calcular(1);
            }
        }

        System.out.println("Precio total productos perecederos: $" + String.format("%.2f",precioPerecederos));
        System.out.println("Precio total productos no perecederos: $" + String.format("%.2f",precioNoPerecederos));
    }
}
