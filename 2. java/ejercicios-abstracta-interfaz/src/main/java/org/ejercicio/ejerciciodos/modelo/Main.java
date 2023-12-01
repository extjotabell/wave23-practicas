package org.ejercicio.ejerciciodos.modelo;


import java.util.List;
import org.ejercicio.ejerciciodos.modelo.impl.Curriculum;
import org.ejercicio.ejerciciodos.modelo.impl.Informe;
import org.ejercicio.ejerciciodos.modelo.impl.LibroPDF;
import org.ejercicio.ejerciciodos.modelo.interfaces.IImprimirContenido;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Perez", "3452947");

        Curriculum curriculum = new Curriculum("1", persona, List.of("Liderezgo", "Python"));
        LibroPDF libroPDF = new LibroPDF("2", 45,"Manuel Mendoza", "Libro de terror","Terror");
        Informe informe = new Informe("3", "Informe numero 1 del primer semestre.", 600, 500, "Daniel Felipe", "Manuel Mendoza" );

        IImprimirContenido.imprimirContenido(curriculum);
        IImprimirContenido.imprimirContenido(libroPDF);
        IImprimirContenido.imprimirContenido(informe);


    }
}
