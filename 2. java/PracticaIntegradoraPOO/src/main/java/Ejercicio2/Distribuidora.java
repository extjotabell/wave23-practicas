package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Distribuidora {
    public static void main(String[] args) {

        //Se crea una lista de productos para poder añadir productos
        // de ambos tipos y tratarlos polimorficamente
        List<Producto> productos = new ArrayList<>();
        productos.add(new Perecedero("Banana", 300, 1));
        productos.add(new NoPerecedero("Chocolate", 300, "Golosina"));
        productos.add(new NoPerecedero("Atun", 300, "Enlatado"));
        productos.add(new Perecedero("Jamon", 500, 5));
        productos.add(new Perecedero("Lechuga", 100, 2));
        productos.add(new NoPerecedero("Durazno", 300, "Enlatado"));
        productos.add(new Perecedero("Manzana", 50, 3));
        productos.add(new NoPerecedero("Sardina", 300, "Enlatado"));
        productos.add(new Perecedero("Pollo", 700, 2));
        productos.add(new NoPerecedero("Arroz", 200, "Cereal"));

        for (Producto producto: productos){
            System.out.println("Precio total de 5 unidades de " + producto);
            System.out.println(producto.calcular(5));
            System.out.println();
        }
    }
}
