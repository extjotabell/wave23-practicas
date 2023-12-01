package org.mercadolibre;

import org.mercadolibre.model.NoPerecedero;
import org.mercadolibre.model.Perecedero;
import org.mercadolibre.model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {

    //psvm
    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();

        Producto producto1 = new Perecedero(1,"Facturas", 3000.0);
        Producto producto2 = new Perecedero(3,"Fideos", 1000.0);
        Producto producto3 = new Perecedero(3,"Chocolate", 4035.0);
        Producto producto4 = new Perecedero(1,"Leche", 3070.87);
        Producto producto5 = new Perecedero(3,"Chocolate", 5678.978);
        Producto producto6 = new NoPerecedero("Electrodomestico", "Televisor", 2000.0);
        Producto producto7 = new NoPerecedero("Mueble", "Silla", 2000.0);
        Producto producto8 = new NoPerecedero("Electrodomestico", "Cafetera", 2000.0);
        Producto producto9 = new NoPerecedero("Electrodomestico", "Pava Electrica", 2000.0);
        Producto producto10 = new NoPerecedero("Mueble", "Mesa", 2000.0);

        productos.addAll(List.of(producto1, producto2, producto3, producto4, producto5, producto6, producto7, producto8, producto9, producto10));

        int cantidadVendida = 5;
        double precioTotal = 0;

        for (Producto producto: productos) {
            precioTotal += producto.calcular(cantidadVendida);
        }

        System.out.println("Precio total al vender " + cantidadVendida + " productos de cada tipo: " + Math.round(precioTotal * 100.0) / 100.0);

    }
}
