import Ejercicio1.PracticaExcepciones;
import Ejercicio2.NoPerecedero;
import Ejercicio2.Perecedero;
import Ejercicio2.Producto;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Distribuidora {
    public static void main(String[] args) {
        // Ejercicio 1
        System.out.println("Ejercicio 1: ");
        System.out.println();

        Ejercicio1();

        System.out.println("Fin Ejercicio 1 ");
        System.out.println("--------------------------------");

        System.out.println();
        System.out.println("Ejercicio 2");

        Ejercicio2();
    }

    private static void Ejercicio1(){
        PracticaExcepciones primerEjercicio = new PracticaExcepciones();

        try {
            primerEjercicio.dividir();
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    private static void Ejercicio2(){
        // Ejercicio 2

        List<Producto> lista = new ArrayList<>();

        lista.add(new Perecedero("Mantequilla", 1200, 3));
        lista.add(new Perecedero("Leche", 800, 2));
        lista.add(new Perecedero("Pan", 500, 8));
        lista.add(new NoPerecedero("Shampoo", 1800, "Higiene"));
        lista.add(new NoPerecedero("Desodorante", 1500, "Higiene"));

        double total = 0;
        for (Producto producto : lista) {
            total += producto.calcularPrecio(5);
        }
        System.out.println("El total de venta es de $"+total);
        System.out.println();
        System.out.println("Fin ejercicio 2");
    }
}