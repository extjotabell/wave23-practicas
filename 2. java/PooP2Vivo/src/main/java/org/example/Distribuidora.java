package org.example;

import org.example.modelo.NoPerecedero;
import org.example.modelo.Perecedero;
import org.example.modelo.Producto;

import java.text.DecimalFormat;

public class Distribuidora {

    public static void main(String[] args) {
        Producto[] productos = new Producto[10];

        productos[0] = new Perecedero("Leche", 1000, 3);
        productos[1] = new NoPerecedero("Arroz", 500, "granos");
        productos[2] = new Perecedero("Pan", 2000, 1);
        productos[3] = new NoPerecedero("Frijol enlatado", 1500, "enlatados");
        productos[4] = new Perecedero("Verduras", 1000, 2);
        productos[5] = new NoPerecedero("Pasta", 2500, "carbohidrato");
        productos[6] = new Perecedero("Pollo", 1500, 1);
        productos[7] = new NoPerecedero("Pescado", 2000, "congelados");
        productos[8] = new Perecedero("Huevos", 500, 3);
        productos[9] = new NoPerecedero("Cloro", 1000, "aseo");

        double precioPerecederos = 0;
        double precioNoPerecederos = 0;
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] instanceof Perecedero) {
                precioPerecederos += productos[i].calcular(5);
            } else if (productos[i] instanceof NoPerecedero) {
                precioNoPerecederos += productos[i].calcular(5);
            }
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Precio total de productos perecederos: " + df.format(precioPerecederos));
        System.out.println("Precio total de productos no perecederos: " + df.format(precioNoPerecederos));
    }
}
