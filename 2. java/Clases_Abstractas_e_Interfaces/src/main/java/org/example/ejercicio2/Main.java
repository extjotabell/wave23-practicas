package org.example.ejercicio2;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Jose Jose", 99, "5348756438");
        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add("Cantar");
        habilidades.add("Bailar");
        Curriculum cv = new Curriculum(persona, habilidades);
        LibroPDF libro =  new LibroPDF(109, "Luis Jose García", "Las mil y un noches de Arabia", "Fantasía");
        Informe informe = new Informe(1089,12,"Pietro Pietri", "Horacio Pullman");

        cv.imprimirDocumento();
        libro.imprimirDocumento();
        informe.imprimirDocumento();

    }
}
