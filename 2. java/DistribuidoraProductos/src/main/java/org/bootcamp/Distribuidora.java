package org.bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    // Rangos para formula de numeros al azar
    private static final int MIN = 1, MAX = 10;

    public static void main(String[] args){
        // Definiciones
        List<Producto> productos = new ArrayList<>();
        double precioTotal = 0;

        // Lista de Productos
        productos.add(new Producto("Camiseta", 10000));
        productos.add(new Perecedero("Huevos", 400, 3));
        productos.add(new NoPerecedero("Arroz", 800, "Almacen"));
        productos.add(new Producto("Libro", 3000));
        productos.add(new Perecedero("Jamon", 700, 2));

        // Calculo de precio total
        for (Producto producto : productos){
            // Utilizo esta formula para poder calcular cantidades al azar y no poner una cantidad fija para cada producto.
            int cantidad = (int)Math.floor(Math.random() * (MAX - MIN + 1) + MIN);
            System.out.println(producto.toString() + ", Cantidad: " + cantidad);
            precioTotal += producto.calcular(cantidad);
        }

        System.out.println("Precio total de la lista de productos: " + precioTotal);
    }

}
