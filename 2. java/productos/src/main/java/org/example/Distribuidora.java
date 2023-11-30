package org.example;

import java.util.ArrayList;

public class Distribuidora {
    public static void main(String[] args) {
       ArrayList<Producto> productos = new ArrayList<>();
       Producto manzana = new Perecedero("Manzana", 100, 3);
       Producto naranja = new Perecedero("Naranja", 100, 5);
       Producto fideo = new NoPerecedero("Fideo 500g", 100, "Pastas");
       Producto detergente = new NoPerecedero("Detergente", 100, "Limpieza");
       Producto papel = new NoPerecedero("Papel", 100, "Limpieza");

       productos.add(manzana);
       productos.add(naranja);
       productos.add(fideo);
       productos.add(detergente);
       productos.add(papel);

       double precioTotal = 0;
       for(Producto producto: productos){
           precioTotal += producto.calcular(5);
       }
        System.out.println("El precio total es de "+precioTotal);
    }
}