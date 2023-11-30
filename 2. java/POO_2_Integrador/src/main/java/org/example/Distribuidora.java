package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        Producto primerProducto = new NoPerecedero("Porotos",100.0, "Legumbres");
        Producto segundoProducto = new Perecedero("Pollo",200.0, 1);
        Producto tercerProducto = new Perecedero("Carne",300.0, 2);
        Producto cuartoProducto = new NoPerecedero("Arroz",100.0, "Granos");
        Producto quintoProducto = new Perecedero("Salmon",200000.0, 3);

        productos.add(primerProducto);
        productos.add(segundoProducto);
        productos.add(tercerProducto);
        productos.add(cuartoProducto);
        productos.add(quintoProducto);

        productos.forEach(producto -> {
            System.out.println(producto.toString());
            System.out.println("Precio final: " + producto.calcular(5));
            System.out.println();
        });
    }
}
