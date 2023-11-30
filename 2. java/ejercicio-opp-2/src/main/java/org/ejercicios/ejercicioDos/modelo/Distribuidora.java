package org.ejercicios.ejercicioDos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {


    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        Producto productoUno = new Perecedero("Producto uno", 20000, 3 );
        Producto productoDos= new NoPerecedero("Producto dos", 11100, "Papeleria" );
        productos.addAll(List.of( productoUno, productoDos ));

        double total = 0;
        for (Producto p: productos){
            total += p.calcular(5);
        }

        System.out.println("TOTAL VENDIDO: $" + total);
    }
}
