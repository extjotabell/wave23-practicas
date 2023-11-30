package org.ejercicios.ejercicioDos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {


    public static void main(String[] args) {

        List<Producto> productos = new ArrayList<>();
        Producto productoUno = new Perecedero("Producto uno", 20000, 3 );
        //Producto productoDos = new Perecedero("Producto dos", 35600, 2 );
        //Producto productoTres = new Perecedero("Producto tres", 46760, 1 );
        //Producto productoCuatro = new Perecedero("Producto cuatro", 89000, 3 );
        //Producto productoCinco = new Perecedero("Producto cinco", 133020, 1 );

        /*Producto productoSeis = new NoPerecedero("Producto seis", 220504, "Electrodomestico" );
        Producto productoSiete = new NoPerecedero("Producto siete", 12000, "Papeleria" );
        Producto productoOcho = new NoPerecedero("Producto ocho", 940000, "Electrodomestico" );
        Producto productoNueve= new NoPerecedero("Producto nueve", 1240000, "Papeleria" );*/
        Producto productoDos= new NoPerecedero("Producto dos", 11100, "Papeleria" );

        productos.addAll(List.of( productoUno, productoDos ));

        double total = 0;

        for (Producto p: productos){
            total += p.calcular(5);
        }

        System.out.println("TOTAL VENDIDO: $" + total);
    }
}
