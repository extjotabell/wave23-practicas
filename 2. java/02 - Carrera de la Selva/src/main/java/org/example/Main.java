package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


    //Carrera
    Carrera carreraDeLaSelva = new Carrera("Carrera de la Selva");

    //A - Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
    carreraDeLaSelva.getCategoriaList().add(new Categoria("Circuito chico", "2 km por selva y arroyos.", 1300, 1500));
    carreraDeLaSelva.getCategoriaList().add(new Categoria("Circuito medio", " 5 km por selva, arroyos y barro.", 2000, 2300));
    carreraDeLaSelva.getCategoriaList().add(new Categoria("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", 0,2800));

    //B - Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar (Por ejemplo: si el participante se inscribe a la categoría Circuito chico y tiene 21 años, el monto a abonar es de $1500).
    Participante part1 = new Participante("Enzo", "Perez", 37);
    Participante part2 = new Participante("Nacho", "Fernandez", 34);
    Participante part3 = new Participante("Diablito", "Echeverry", 17);

    //C - Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
    try {
        carreraDeLaSelva.getInscripcionList().add(new Inscripcion(carreraDeLaSelva.getCategoriaList().get(2), part1, carreraDeLaSelva));
        carreraDeLaSelva.getInscripcionList().add(new Inscripcion(carreraDeLaSelva.getCategoriaList().get(1), part2, carreraDeLaSelva));

        //Lanza excepción por ya estar inscripto
        //carreraDeLaSelva.getInscripcionList().add(new Inscripcion(carreraDeLaSelva.getCategoriaList().get(2), part2, carreraDeLaSelva));

        //Lanza excepción por ya ser menor
        //carreraDeLaSelva.getInscripcionList().add(new Inscripcion(carreraDeLaSelva.getCategoriaList().get(2), part3, carreraDeLaSelva));

        carreraDeLaSelva.getInscripcionList().add(new Inscripcion(carreraDeLaSelva.getCategoriaList().get(0), part3, carreraDeLaSelva));

    }catch (IllegalArgumentException e) {
        System.out.println("Error: " + e.getMessage());
    }

    //D - Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
    System.out.println(carreraDeLaSelva.toStringModificado());

    //E - Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
    Inscripcion inscripcionAEliminar = carreraDeLaSelva.getInscripcionList().get(2);
    System.out.println("Se desinscribe al participante: " + inscripcionAEliminar.getParticipante().getNumero() + ", "
            + inscripcionAEliminar.getParticipante().getNombre() +
        " " + inscripcionAEliminar.getParticipante().getApellido() + " de la categoria: " +
            inscripcionAEliminar.getCategoria().getNombre() + "."
    );
    carreraDeLaSelva.desinscribirParticipante(inscripcionAEliminar.getId());

    System.out.println("\n" + carreraDeLaSelva.toStringModificado());

    //F - Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
    System.out.println(carreraDeLaSelva.mostrarTotalRecaudado());

    }

}