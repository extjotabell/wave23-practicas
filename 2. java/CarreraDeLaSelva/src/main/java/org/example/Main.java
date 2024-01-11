package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Inscripcion> inscripciones = new ArrayList<>();
        Map<Categoria, Set<Participante>> mapInscritos = new HashMap<>();

        // Registro de categorias

        Categoria categoriaUno = new Categoria(1, "Circuito chico", "2km por selva y arroyos");
        Categoria categoriaDos = new Categoria(2, "Circuito mediano", "5km por selva, arroyos y barro");
        Categoria categoriaTres = new Categoria(3, "Circuito avanzado", "10km por selva, arroyos, barro y escalada en piedra");

        mapInscritos.put(categoriaUno, new HashSet<>());
        mapInscritos.put(categoriaDos, new HashSet<>());
        mapInscritos.put(categoriaTres, new HashSet<>());

        System.out.println("CATEGORIAS INICIALES AGREGADAS:  ");
        for (Categoria c : mapInscritos.keySet())
            System.out.println("   CATEGORIA: " + c.getNombre());
        System.out.println(" ");

        // Crear un nuevo participante

        Participante participanteUno = new Participante(1, 12345, "Juan", "lopez", 25,
                "3123570609", "3123458484", "A+");
        Inscripcion inscripcionUno = new Inscripcion(1, categoriaUno, participanteUno);

        inscripciones.add(inscripcionUno);
        mapInscritos.get(categoriaUno).add(participanteUno);
        System.out.println("NUEVO PARTICIPANTE, INSCRIPCION Y MONTO:  ");
        System.out.println("   PARTICIPANTE: " + participanteUno.getNombre() + " "+ participanteUno.getApellido() );
        System.out.println("   COSTO INSCRIPCION: $" + inscripcionUno.getMonto());
        System.out.println(" ");

        // Inscripción de participantes

        //Categoria 1
        Participante participanteDos = new Participante(2,100002, "Juana", "Ruiz", 21, "3124389", "312656789", "A+" );
        Inscripcion inscripcionDos = new Inscripcion(2, categoriaUno, participanteDos);

        inscripciones.add(inscripcionDos);
        mapInscritos.get(categoriaUno).add(participanteDos);
        //Categoria 2
        Participante participanteTres = new Participante(3,000003, "Daniel", "Lopez", 32, "312456789", "312556789", "O+" );
        Inscripcion inscripcionTres = new Inscripcion(3, categoriaDos, participanteTres);

        inscripciones.add(inscripcionTres);
        mapInscritos.get(categoriaDos).add(participanteTres);

        //Categoria 3
        Participante participanteCuatro = new Participante(4,000004, "Paula", "Gaona", 50, "312456569", "312456781", "B+" );
        Inscripcion inscripcionCuatro = new Inscripcion(4, categoriaTres, participanteCuatro);

        inscripciones.add(inscripcionCuatro);
        mapInscritos.get(categoriaTres).add(participanteCuatro);

        System.out.println("C. INSCRITOS: ");
        for (Categoria c : mapInscritos.keySet()) {
            System.out.println("  CATEGORIA " + c.getNombre());
            for (Participante p : mapInscritos.get(c))
                System.out.println("   PARTICIPANTE: " + p.getNombre() + " " + p.getApellido());
            System.out.println(" ");
        }

        // Mostrar participantes con sus datos

        String categoriaABuscar = "Circuito chico";
        System.out.println("INFO PARTICIPANTES DE LA CATEGORIA  "+ categoriaABuscar + ":");

        for(int i=0; i < inscripciones.size(); i++){
            if(inscripciones.get(i).getCategoria().getNombre().equals(categoriaABuscar)){
                System.out.println("    Participante " + inscripciones.get(i).getParticipante().getNombre()
                        + " " + inscripciones.get(i).getParticipante().getApellido()
                        + ", dni: " + inscripciones.get(i).getParticipante().getDni() +
                        ", Numero inscripcion " + inscripciones.get(i).getId());
            }
        }
    }
}