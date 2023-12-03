package Ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Imprimir> lista = new ArrayList<>();
        lista.add(new Libro(2, "J.K.K Rowling", "Harry Potter", "Fantasia"));
        lista.add(new Informe("Lorem Ipsum", 30, "Felipe"));
        lista.add(new Curriculum("Tomas", List.of("Java")));
        lista.forEach(Imprimir::imprimir);
    }
}
