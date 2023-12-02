package practica.Imprenta;

import java.util.List;

public class Imprenta {
    public static void main(String[] args) {
        Documento d1 = new Curriculum(new Persona("Marcos", "Costanzo", "40955907", List.of(new String[]{"habilidad1","habilidad2"})));
        Documento d2 = new LibroPDF(25, "Pepe", "Programación en C", "Educativo");
        Documento d3 = new Informe("Informe de prueba", 15, "Carlos", "Sofia");

        Impresora.imprimir(d1);
        Impresora.imprimir(d2);
        Impresora.imprimir(d3);
    }
}