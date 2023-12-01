package Ejercicio2;

import Ejercicio2.imprimibles.Curriculum;
import Ejercicio2.imprimibles.Informe;
import Ejercicio2.imprimibles.Libro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimible> lista = new ArrayList<>();
        lista.add(new Libro("J.K.K Rowling", "Harry Potter", "Fantasia", 500));
        lista.add(new Informe("Lorem Ipsum", 30, "Felipe"));
        lista.add(new Curriculum("Tomas", Arrays.asList("Java")));
        lista.stream().forEach(Imprimible::imprimir);
    }
}
