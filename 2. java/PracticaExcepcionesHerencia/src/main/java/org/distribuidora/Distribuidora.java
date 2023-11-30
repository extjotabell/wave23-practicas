package org.distribuidora;
import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {
        List <Producto> lista = new ArrayList<>();
        lista.add(new Perecedero("mantequilla",1200,3));
        lista.add(new Perecedero("manzana",400,10));
        lista.add(new NoPerecedero("shampoo",1500,"higene"));
        lista.add(new NoPerecedero("desodorante",700,"higene"));
        lista.add(new Perecedero("jamon",900,1));

        double total = 0;
        for (Producto producto : lista) {
            total += producto.calcularPrecio(5);
        }
        System.out.println("El total de venta es de $"+total);
    }
}