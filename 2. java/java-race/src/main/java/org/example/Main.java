package org.example;

import java.util.*;

public class Main {
    private static List<Participante> participantes = new ArrayList<>();
    private static List<Inscripcion> inscripciones = new ArrayList<>();
    private static Map<String, List<Inscripcion>> inscripcionesPorCategoria = new HashMap<>();


    public static void main(String[] args) {
        // Crear 3 objetos de tipo categoría (uno por cada categoría) con sus respectivos datos.
        Categoria circuitoChico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria circuitoMedio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria circuitoAvanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

        // Crear un nuevo participante e inscribirlo en una categoría. Calcular el monto de inscripción que deberá abonar
        Participante participante1 = crearParticipante(12345678, "Juan", "Perez", 17, 113456789, 1198765432, "0+");
        inscribirParticipante(circuitoChico, participante1);

        // Inscribir al azar algunos participantes en diferentes categorías (al menos uno en cada una).
        Participante participante2 = crearParticipante(12345678, "Pablo", "Gomez", 24, 113456789, 1198765432, "0+");
        inscribirParticipante(circuitoMedio, participante2);

        Participante participante3 = crearParticipante(12345678, "Diego", "Lopez", 45, 113456789, 1198765432, "0+");
        inscribirParticipante(circuitoAvanzado, participante3);

        inscribirParticipante(circuitoMedio, participante3);

        Participante participante4 = crearParticipante(12345678, "Jorge", "Gutierrez", 15, 113456789, 1198765432, "0+");
        inscribirParticipante(circuitoAvanzado, participante4);

        // Mostrar por pantalla todos los inscriptos a una determinada categoría con sus correspondientes datos y número de inscripción.
        listarInscriptos(circuitoChico.nombre);
        listarInscriptos(circuitoMedio.nombre);
        listarInscriptos(circuitoAvanzado.nombre);

        // Desinscribir a un participante. Mostrar como queda la lista de inscriptos en la categoría donde se encontraba.
        desinscribirParticipante(participante3);

        // Calcular el monto total recaudado por cada categoría y el total de toda la carrera incluyendo todas las categorías.
        calcularMontoPorCategoria(circuitoMedio.nombre);
        calcularMontoRecaudado();
    }

    private static Participante crearParticipante(int dni, String nombre, String apellido, int edad, int telefono, int telefonoEmergencia, String grupoSanguineo) {
        Participante participante = new Participante(participantes.size() + 1, dni, nombre, apellido, edad, telefono, telefonoEmergencia, grupoSanguineo);
        participantes.add(participante);
        return participante;
    }

    private static void inscribirParticipante(Categoria categoria, Participante participante) {
        boolean esValida = validarInscripcion(participante);
        if (esValida) {
            System.out.println("Inscribiendo participante: " + participante.getFullName());
            Inscripcion inscripcion = new Inscripcion(inscripciones.size() + 1, categoria, participante);
            if (inscripcion.monto != 0) {
                inscripciones.add(inscripcion); // TODO: ¿Es necesaria la lista de inscripciones?

                agregarInscripcion(categoria.nombre, inscripcion);
                System.out.println("Se inscribió el participante: " + participante.getFullName());
                System.out.println("Categoría: " + categoria.nombre + ". Monto: $" + inscripcion.monto);
                System.out.println("------------------------");
            }
        } else {
            System.out.println("ERROR - No se pudo inscribir al participante: " + participante.getFullName() + " en " + categoria.nombre + ". Solo puede inscribirse a una categoría");
        }
    }

    private static void desinscribirParticipante(Participante participante) {
        for (Map.Entry<String, List<Inscripcion>> entry : inscripcionesPorCategoria.entrySet()) {
            List<Inscripcion> inscripcionList = entry.getValue();

            Iterator<Inscripcion> iterator = inscripcionList.iterator();
            while (iterator.hasNext()) {
                Inscripcion inscripcion = iterator.next();
                if (inscripcion.participante.equals(participante)) {
                    System.out.println("------------------------");
                    System.out.println("Se eliminó suscripción de la categoria " + inscripcion.categoria.nombre + " al participante: " + participante.getFullName());

                    iterator.remove();
                    listarInscriptos(inscripcion.categoria.nombre);
                    //TODO: ¿Buscar otra alternativa a Iterator?
                }
            }
        }
    }

    private static void agregarInscripcion(String categoria, Inscripcion inscripcion) {
        if (!inscripcionesPorCategoria.containsKey(categoria)) {
            inscripcionesPorCategoria.put(categoria, new ArrayList<>());
        }
        inscripcionesPorCategoria.get(categoria).add(inscripcion);
    }

    public static boolean validarInscripcion(Participante participante) {
        for (Inscripcion inscripto : inscripciones) {
            if (inscripto.participante == participante) {
                return false;
            }
        }
        return true;
    }

    public static void listarInscriptos(String categoria) {
        System.out.println("------------------------");
        System.out.println("Inscriptos en la categoria " + categoria);
        inscripcionesPorCategoria.get(categoria).forEach(System.out::println);
    }

    public static void calcularMontoPorCategoria(String categoria) {
        List<Inscripcion> inscripciones = inscripcionesPorCategoria.get(categoria);
        double monto = sumarMontosPorInscripcion(inscripciones);

        System.out.println("------------------------");
        System.out.println("Total recaudado en la categoria " + categoria + " $" + monto);
    }

    public static void calcularMontoRecaudado() {
        double montoTotal = 0;
        for (Map.Entry<String, List<Inscripcion>> entry : inscripcionesPorCategoria.entrySet()) {
            List<Inscripcion> inscripciones = entry.getValue();

            double montoPorCategoria = sumarMontosPorInscripcion(inscripciones);
            montoTotal += montoPorCategoria;
        }
        System.out.println("------------------------");
        System.out.println("Total recaudado en la carrera $" + montoTotal);
    }

    public static double sumarMontosPorInscripcion(List<Inscripcion> inscripciones) {
        double monto = 0;

        for (Inscripcion inscripcion : inscripciones) {
            monto += inscripcion.monto;
        }
        return monto;
    }
}