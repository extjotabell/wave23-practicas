package main;

import java.util.*;

public class Distribuidora {
    public static void main(String[] args) {
        double precioTotal = 0;
        List<Producto> productos = new ArrayList<>();

        Producto p1 = new Perecedero("Pan bimbo artesano", 1500, 1);
        Producto p2 = new Perecedero("Mayonesa", 850, 2);
        Producto p3 = new Perecedero("Alfajor Oreo", 600, 3);
        Producto p4 = new Perecedero("Arroz", 750, 4);
        Producto p5 = new NoPerecedero("Cacao", 800, "No perecedero");

        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);

        for (Producto producto : productos) {
            precioTotal += producto.calcular(5);
        }

        System.out.println("El precio total de los productos a comprar es de: " + String.format("%.2f", precioTotal));
    }
}
