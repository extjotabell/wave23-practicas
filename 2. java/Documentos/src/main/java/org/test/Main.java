package org.test;

import org.bootcamp.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Persona lucas = new Persona("Lucas", "Salerno", 29);
        List<String> habilidades = List.of("Java", "SQL", "Linux");
        Autor tolkien = new Autor("John Ronald Reuel", "Tolkien", 50, "J.R.R.");
        Autor maria = new Autor("Maria", "Perez", 23, "M.P.");
        Revisor revisor = new Revisor("Eduardo", "Fernandez", 55, 123);

        Curriculum curriculum = new Curriculum(lucas, habilidades);
        System.out.println(IDocumento.imprime(curriculum));

        Libro libro = new Libro(tolkien, "El Señor de los Anillos", "Fantasia", 300);
        System.out.println(IDocumento.imprime(libro));

        Informe informe = new Informe(maria, 2000, 5, revisor);
        System.out.println(IDocumento.imprime(informe));

    }

}
