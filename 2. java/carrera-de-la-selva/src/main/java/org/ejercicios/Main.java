package org.ejercicios;

import org.ejercicios.modelo.Categoria;
import org.ejercicios.modelo.Inscripcion;
import org.ejercicios.modelo.Participante;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Inscripcion> inscripciones = new ArrayList<>();
        Map<Categoria, Set<Participante>> mapaInscritos = new HashMap<>();


        //a. Registro de categorias

        Categoria categoriaUno = new Categoria("1", "Circuito chico", "2 km por selva y arroyos.");
        Categoria categoriaDos = new Categoria("2", "Circuito medio", "5 km por selva, arroyos y barro.");
        Categoria categoriaTres = new Categoria("3", "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        mapaInscritos.put(categoriaUno, new HashSet<>());
        mapaInscritos.put(categoriaDos, new HashSet<>());
        mapaInscritos.put(categoriaTres, new HashSet<>());

        System.out.println("A. CATEGORIAS INICIALES AGREGADAS:  ");
        for (Categoria c : mapaInscritos.keySet())
            System.out.println("   CATEGORIA " + c.getNombre());
        System.out.println(" ");



        //b.

        Participante participanteUno = new Participante("1","000001", "Juan", "Lopez", 25, "312456789", "312456789", "O+" );
        Inscripcion inscripcionUno = new Inscripcion("1", categoriaUno, participanteUno);

        inscripciones.add(inscripcionUno);
        mapaInscritos.get(categoriaUno).add(participanteUno);
        System.out.println("B. NUEVO PARTICIPANTE, INSCRIPCION Y MONTO:  ");
        System.out.println("   PARTICIPANTE: " + participanteUno.getNombre() + " "+ participanteUno.getApellido() );
        System.out.println("   COSTO INSCRIPCION: $" + inscripcionUno.getMonto() );
        System.out.println(" ");


        //c.
            //Categoria 1
        Participante participanteDos = new Participante("2","000002", "Juana", "Ruiz", 21, "3124389", "312656789", "A+" );
        Inscripcion inscripcionDos = new Inscripcion("2", categoriaUno, participanteDos);

        inscripciones.add(inscripcionDos);
        mapaInscritos.get(categoriaUno).add(participanteDos);
            //Categoria 2
        Participante participanteTres = new Participante("3","000003", "Daniel", "Lopez", 32, "312456789", "312556789", "O+" );
        Inscripcion inscripcionTres = new Inscripcion("3", categoriaDos, participanteTres);

        inscripciones.add(inscripcionTres);
        mapaInscritos.get(categoriaDos).add(participanteTres);

            //Categoria 3
        Participante participanteCuatro = new Participante("4","000004", "Paula", "Gaona", 50, "312456569", "312456781", "B+" );
        Inscripcion inscripcionCuatro = new Inscripcion("4", categoriaTres, participanteCuatro);

        inscripciones.add(inscripcionCuatro);
        mapaInscritos.get(categoriaTres).add(participanteCuatro);

        System.out.println("C. INSCRITOS: ");
        for (Categoria c : mapaInscritos.keySet()) {
            System.out.println("  CATEGORIA " + c.getNombre());
            for (Participante p : mapaInscritos.get(c))
                System.out.println("   PARTICIPANTE: " + p.getNombre() + " " + p.getApellido());
            System.out.println(" ");
        }


        //d.

        String categoriaABuscar = "Circuito chico";
        System.out.println("D. INFO PARTICIPANTES DE LA CATEGORIA  "+ categoriaABuscar + ":");
        for (int i = 0; i < inscripciones.size(); i++) {
            if(inscripciones.get(i).getCategoria().getNombre().equals(categoriaABuscar)){
                System.out.println("    Participante " + inscripciones.get(i).getParticipante().getNombre()  + " Numero inscripcion "
                                                    + inscripciones.get(i).getId());
            }
        }
        System.out.println(" ");

        //e.

        Participante participanteABorrar = participanteUno;
        Categoria infoCategoria = inscripciones.get(inscripciones.indexOf(inscripcionUno)).getCategoria();
        System.out.println("E. BORRANDO AL PARTICIPANTE  "+ participanteABorrar.getNombre() + " "+ participanteABorrar.getApellido() + ":");



        System.out.println("  Lista antes de borrar: ");
        for (Participante p : mapaInscritos.get(infoCategoria))
            System.out.println("   "+p.getNombre() +" "+ p.getApellido() );

        //Borrando
        inscripciones.remove(inscripcionUno);
        mapaInscritos.get(infoCategoria).remove(participanteABorrar);

        System.out.println("  Lista despues de borrar: ");
        for (Participante p : mapaInscritos.get(infoCategoria))
            System.out.println("   "+p.getNombre() +" "+ p.getApellido() );



        //f.
        //Por cada categoria
        double totalCategoria1 = 0;
        double totalCategoria2 = 0;
        double totalCategoria3 = 0;

        for(int i = 0; i < inscripciones.size(); i++){
            if (inscripciones.get(i).getCategoria().getNombre().equals("Circuito chico"))
                totalCategoria1 = totalCategoria1 + inscripciones.get(i).getMonto();

            else if (inscripciones.get(i).getCategoria().getNombre().equals("Circuito medio"))
                totalCategoria2 = totalCategoria2 + inscripciones.get(i).getMonto();

            else if (inscripciones.get(i).getCategoria().getNombre().equals("Circuito avanzado"))
                totalCategoria3 = totalCategoria3 + inscripciones.get(i).getMonto();

        }
        System.out.println("F. INFO MONTOS INDIVIDUALES Y TOTAL: ");
        System.out.println("  TOTAL CAT. CIRCUITO CHICO " + totalCategoria1);
        System.out.println("  TOTAL CAT. CIRCUITO MEDIO " + totalCategoria2);
        System.out.println("  TOTAL CAT. CIRCUITO AVANZADO " + totalCategoria3);
        System.out.println("  SUMA TOTAL  " + (totalCategoria1 + totalCategoria2 + totalCategoria3));



    }


}