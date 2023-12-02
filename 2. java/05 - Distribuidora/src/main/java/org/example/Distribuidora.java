package org.example;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        productos.add(new Perecedero("Arroz", 80.00, 5));
        productos.add(new Perecedero("Pan", 80.00, 2));
        productos.add(new NoPerecedero("Jabon", 80.00, "Perfumería"));
        productos.add(new NoPerecedero("Shampoo", 80.00, "Perfumería"));
        productos.add(new Perecedero("Leche", 80.00, 1));
        productos.add(new Perecedero("Carne", 80.00, 3));
        productos.add(new Perecedero("Pollo", 80.00, 4));
        productos.add(new NoPerecedero("Acondicionador", 80.00, "Perfumería"));
        productos.add(new NoPerecedero("Algodon", 80.00, "Perfumería"));
        productos.add(new NoPerecedero("Pasta de dientes", 80.00, "Perfumería"));

        List<Perecedero> productosPerecederos = new ArrayList<>();
        List<NoPerecedero> productosNoPerecederos = new ArrayList<>();

        for (Producto p : productos) {
            if (p instanceof Perecedero) {
                productosPerecederos.add((Perecedero) p);
            } else if (p instanceof NoPerecedero) {
                productosNoPerecederos.add((NoPerecedero) p);
            }
        }


        double precioPerecederos = 0;
        double precioNoPerecederos = 0;

        if(productosPerecederos.size() >= 5){
            for (Perecedero p: productosPerecederos){
                precioPerecederos += p.calcular(2);
            }
        }

        if(productosNoPerecederos.size() >= 5){
            for (NoPerecedero p: productosNoPerecederos){
                precioNoPerecederos += p.calcular(1);
            }
        }

        System.out.println("Precio total productos perecederos: $" + String.format("%.2f",precioPerecederos));
        System.out.println("Precio total productos no perecederos: $" + String.format("%.2f",precioNoPerecederos));
    }
}