package org.example;

import org.example.modelo.Categoria;
import org.example.modelo.Inscripcion;
import org.example.modelo.Participante;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<Categoria> categorias = new ArrayList<>();
    private static List<Inscripcion> inscripciones = new ArrayList<>();

    public static void main(String[] args) {

        // Creamos las categorías
        categorias.add(new Categoria(1, "Circuito chico", "2 km por selva y arroyos"));
        categorias.add(new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro"));
        categorias.add(new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra"));

        // Inscribimos un participante a cualquier categoria
        Participante participante1 = new Participante(1, "123456789", "Sebastian", "Ospina", 23, "1234567890", "911", "A+");
        inscripciones.add(new Inscripcion(1, categorias.get(1), participante1));

        System.out.println(inscripciones.get(0));
        System.out.println("-----------------");

        //Inscribir participantes aletorios a cada categoria
        Participante participante2 = new Participante(2, "123456789", "Participante 2", "Apellido 2", 17, "1234567890", "911", "A+");
        Participante participante3 = new Participante(3, "123456789", "Participante 3", "Apellido 3", 30, "1234567890", "911", "A+");
        Participante participante4 = new Participante(4, "123456789", "Participante 4", "Apellido 4", 46, "1234567890", "911", "A+");

        inscripciones.add(new Inscripcion(2, categorias.get(0), participante2));
        inscripciones.add(new Inscripcion(3, categorias.get(2), participante3));
        inscripciones.add(new Inscripcion(4, categorias.get(1), participante4));

        //Imprimir los inscritos a cada categoria
        mostrarInscritos(1);
        mostrarInscritos(2);
        mostrarInscritos(3);
        System.out.println("-----------------");

        //Desinscribir a un participante
        desinscribir(4);

        //Calcular totales
        calcularMontoRecaudadoPorCategoria();
        calcularMontoRecaudadoTotal();



    }

    private static void mostrarInscritos(int categoriaId) {
        Categoria categoria = categorias.stream().filter(c -> c.getId() == categoriaId).findFirst().orElse(null);
        if (categoria == null) {
            throw new IllegalArgumentException("La categoría no existe");
        }

        System.out.println("Inscritos a la categoría " + categoria.getNombre());
        for (Inscripcion inscripcion : inscripciones.stream().filter(i -> i.getCategoria().getId() == categoriaId).collect(Collectors.toList())) {
            System.out.println(inscripcion);
        }
    }

    public static void desinscribir(int numeroParticipante) {
        // Buscamos la inscripción del participante
        Inscripcion inscripcion = inscripciones.stream().filter(i -> i.getParticipante().getNumeroParticipante() == numeroParticipante).findFirst().orElse(null);
        if (inscripcion == null) {
            throw new IllegalArgumentException("El participante no está inscrito");
        }

        int idCategoria = inscripcion.getCategoria().getId();
        // Eliminamos la inscripción de la lista
        inscripciones.remove(inscripcion);
        mostrarInscritos(idCategoria);
    }

    public static void calcularMontoRecaudadoPorCategoria() {
        // Inicializamos los montos recaudados por categoría
        Map<Categoria, Integer> montosRecaudados = new HashMap<>();
        for (Categoria categoria : categorias) {
            montosRecaudados.put(categoria, 0);
        }

        // Iteramos sobre las inscripciones
        for (Inscripcion inscripcion : inscripciones) {
            // Obtenemos el monto de la inscripción
            int montoInscripcion = inscripcion.getMonto();

            // Actualizamos el monto recaudado por la categoría
            montosRecaudados.put(inscripcion.getCategoria(), montosRecaudados.get(inscripcion.getCategoria()) + montoInscripcion);
        }

        // Imprimimos el monto recaudado por cada categoría
        for (Map.Entry<Categoria, Integer> entry : montosRecaudados.entrySet()) {
            System.out.println("Monto recaudado por la categoría " + entry.getKey().getNombre() + ": " + entry.getValue());
        }
    }

    public static void calcularMontoRecaudadoTotal() {
        // Inicializamos el monto total recaudado
        int montoTotalRecaudado = 0;

        // Iteramos sobre las inscripciones
        for (Inscripcion inscripcion : inscripciones) {
            // Obtenemos el monto de la inscripción
            int montoInscripcion = inscripcion.getMonto();

            // Actualizamos el monto total recaudado
            montoTotalRecaudado += montoInscripcion;
        }

        // Devolvemos el monto total recaudado
        System.out.println("El monton total recaudado es: "+ montoTotalRecaudado);
    }


}
