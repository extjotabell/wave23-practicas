package org.example;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    public static void main(String[] args) {
        double total = 0;

        List<Producto> productos = new ArrayList<Producto>();
        Producto producto1  = new Perecedero("Harina", 1500, 1);
        productos.add(producto1);
        Producto producto2  = new Perecedero("Arroz", 3300, 2);
        productos.add(producto2);
        Producto producto3  = new Perecedero("Atun", 2000, 3);
        productos.add(producto3);
        Producto producto4  = new Perecedero("Quinoa", 1800, 4);
        productos.add(producto4);
        Producto producto5  = new Perecedero("Leche",1200, 5);
        productos.add(producto5);
        Producto producto6  = new NoPerecedero("Porotos", 1000, "Legumbres");
        productos.add(producto6);
        Producto producto7  = new NoPerecedero("Lentejas", 2200, "Legumbres");
        productos.add(producto7);
        Producto producto8  = new NoPerecedero("Garbanzos", 1500, "Legumbres");
        productos.add(producto8);
        Producto producto9  = new NoPerecedero("Patas larga", 800, "Pastas");
        productos.add(producto9);
        Producto producto10 = new NoPerecedero("Pasta corta",1200, "Pastas");
        productos.add(producto10);

        for(Producto p: productos) {
            int cantidadProductos = 5;
            total += p.calcular(cantidadProductos);
            System.out.println("Precio total " + cantidadProductos + " "+ p.getNombre() + ": " + p.calcular(cantidadProductos));
        }
        System.out.println("Precio total: " + total);
    }
}