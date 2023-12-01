package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Producto p1 = new Producto("Producto Uno", 40);
        Producto p2 = new Perecedero("Producto Perecedero", 68, 7);
        Producto p3 = new NoPerecedero("Producto No Perecedero", 140, "legumbre");

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);

        double total = 0;
        for (Producto p : productos) {
            total += p.calcular(5);
        }

        System.out.printf("El costo total es de: %.2f\n",total);
    }
}