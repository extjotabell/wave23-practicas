package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List <Participante> lista = new ArrayList<>();

        Competencia circuito_chico = new Competencia(
                1,"Circuito Chico","2km por selva y arroyo");
        Competencia circuito_medio = new Competencia(2,"Circuito Medio",
                "5km por selvas y arroyos");
        Competencia circuito_avanzado = new Competencia(3,"Circuito Avanzado",
                "10km por selva,arroyos y escalada en piedra");

        lista.add( new Participante(1,"Circuito Chico",
                "2km por selva y arroyo",5,1,1234,
                "Martin","Lackington",26,"+569232",
                "+569787","o+"));

        lista.add( new Participante(2,"Circuito Medio",
                "5km por selvas y arroyo",4,2,12345,
                "Alfredo","Romero",30,"+569797",
                "+569667","a+"));
        lista.add (new Participante(3,"Circuito Avanzado",
                "10km por selvas, arroyos y escalada en piedra",3,3,12665,
                "Esteban","Paredes",78,"+569008",
                "+5699997","ab+"));

        System.out.println(lista.get(0).montoInscripcion());

        System.out.println(lista.get(0));
        System.out.println(lista.get(1));
        System.out.println(lista.get(2));

        lista.remove(0);
        System.out.println(lista);

        System.out.println(lista.get(0).montoInscripcion()+lista.get(1).montoInscripcion());
    }
}