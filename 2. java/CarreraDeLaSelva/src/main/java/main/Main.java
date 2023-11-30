package main;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Categoria> categorias = new ArrayList<>();
        List<Participante> participantes = new ArrayList<>();
        List<Inscripcion> inscripcionesCatA = new ArrayList<>();
        List<Inscripcion> inscripcionesCatB = new ArrayList<>();
        List<Inscripcion> inscripcionesCatC = new ArrayList<>();
        Map<Categoria, List<Inscripcion>> inscripcionesPorCategoria = new HashMap<>();

        cargarCategorias(categorias);
        cargarInscripciones(categorias, participantes, inscripcionesCatA, inscripcionesCatB, inscripcionesCatC, inscripcionesPorCategoria);

        System.out.println("Listado de inscrpiciones por categoría:");
        mostrarCategorias(inscripcionesPorCategoria);
        System.out.println();

        System.out.println("Desinscribiendo participante:");
        desinscribirParticipante(4, participantes, inscripcionesCatA, inscripcionesCatB, inscripcionesCatC, inscripcionesPorCategoria);
        System.out.println();

        System.out.println("Listado de inscripciones por categoría luego de borrrar un participante:");
        mostrarCategorias(inscripcionesPorCategoria);
        System.out.println();

        System.out.println("Monto total recaudado por categoría:");
        mostrarMontosCategorias(categorias);
        System.out.println();
    }

    private static void cargarCategorias(List<Categoria> categorias) {
        Categoria c1 = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
        Categoria c2 = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
        Categoria c3 = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedras");

        categorias.add(c1);
        categorias.add(c2);
        categorias.add(c3);
    }

    private static void cargarInscripciones(List<Categoria> categorias, List<Participante> participantes, List<Inscripcion> inscripcionesCatA, List<Inscripcion> inscripcionesCatB, List<Inscripcion> inscripcionesCatC, Map<Categoria, List<Inscripcion>> inscripcionesPorCategoria) {
        Participante p1 = new Participante(1, 40955907, "Marcos", "Costanzo", 25, 1134654461, 1122334455, "0-");
        if (participantes.contains(p1)) {
            System.out.println("El participante ya tiene una inscripción a una categoría");
        }
        else {
            Inscripcion i1 = new Inscripcion(1, categorias.get(0), p1, 1500);
            categorias.get(0).setMontoTotal(categorias.get(0).getMontoTotal() + 1500);
            inscripcionesCatA.add(i1);
            participantes.add(p1);
        }

        Participante p2 = new Participante(2, 40123456, "Pedro", "Fernandez", 17, 1122445566, 1199887766, "A+");
        if (participantes.contains(p2)) {
            System.out.println("El participante ya tiene una inscripción a una categoría");
        }
        else {
            Inscripcion i2 = new Inscripcion(2, categorias.get(1), p2, 2000);
            categorias.get(1).setMontoTotal(categorias.get(1).getMontoTotal() + 2000);
            inscripcionesCatB.add(i2);
            participantes.add(p2);
        }

        Participante p3 = new Participante(3, 209345680, "Omar", "Nandez", 45, 1177335599, 1155998877, "0+");
        if (participantes.contains(p3)) {
            System.out.println("El participante ya tiene una inscripción a una categoría");
        }
        else {
            Inscripcion i3 = new Inscripcion(3, categorias.get(2), p3, 2800);
            categorias.get(2).setMontoTotal(categorias.get(2).getMontoTotal() + 2800);
            inscripcionesCatC.add(i3);
            participantes.add(p3);
        }

        Participante p4 = new Participante(4, 209311680, "Pepe", "Sand", 65, 1175555599, 1155555877, "0+");
        if (participantes.contains(p4)) {
            System.out.println("El participante ya tiene una inscripción a una categoría");
        }
        else {
            Inscripcion i4 = new Inscripcion(4, categorias.get(2), p4, 2800);
            categorias.get(2).setMontoTotal(categorias.get(2).getMontoTotal() + 2800);
            inscripcionesCatC.add(i4);
            participantes.add(p4);
        }


        // Una vez cargadas las listas, cargo el mapa con cada categoria
        inscripcionesPorCategoria.put(categorias.get(0), inscripcionesCatA);
        inscripcionesPorCategoria.put(categorias.get(1), inscripcionesCatB);
        inscripcionesPorCategoria.put(categorias.get(2), inscripcionesCatC);
    }

    private static void desinscribirParticipante(int nroParticipante, List<Participante> participantes, List<Inscripcion> inscripcionesCatA, List<Inscripcion> inscripcionesCatB, List<Inscripcion> inscripcionesCatC, Map<Categoria, List<Inscripcion>> inscripcionesPorCategoria) {
        Categoria cat = null;
        Participante p = null;
        Inscripcion i = null;

        for (Participante participante : participantes) {
            if (participante.getNroParticipante() == nroParticipante) {
                p = participante;
            }
        }

        participantes.remove(p);

        for (Inscripcion inscripcion : inscripcionesCatA) {
            if (inscripcion.getParticipante().getNroParticipante() == nroParticipante) {
                i = inscripcion;
                cat = inscripcion.getCategoria();
            }
        }

        inscripcionesCatA.remove(i);

        for (Inscripcion inscripcion : inscripcionesCatB) {
            if (inscripcion.getParticipante().getNroParticipante() == nroParticipante) {
                i = inscripcion;
                cat = inscripcion.getCategoria();
            }
        }

        inscripcionesCatB.remove(i);

        for (Inscripcion inscripcion : inscripcionesCatC) {
            if (inscripcion.getParticipante().getNroParticipante() == nroParticipante) {
                i = inscripcion;
                cat = inscripcion.getCategoria();
            }
        }

        inscripcionesCatC.remove(i);

        for (Inscripcion inscripcion : inscripcionesPorCategoria.get(cat)) {
            if (inscripcion.getParticipante().getNroParticipante() == nroParticipante) {
                inscripcionesPorCategoria.get(cat).remove(inscripcion);
            }
        }
    }

    private static void mostrarCategorias(Map<Categoria, List<Inscripcion>> inscripcionesPorCategoria) {
        for (Map.Entry<Categoria, List<Inscripcion>> mapa : inscripcionesPorCategoria.entrySet()) {
            System.out.println("Nro. Categoría: " + mapa.getKey().getId());
            System.out.println();
            for (Inscripcion lista : mapa.getValue()) {
                System.out.println("Nro. Participante: " + lista.getParticipante().getNroParticipante());
                System.out.println("DNI: " + lista.getParticipante().getDni());
                System.out.println("Nombre: " + lista.getParticipante().getNombre());
                System.out.println("Apellido: " + lista.getParticipante().getApellido());
                System.out.println("Edad: " + lista.getParticipante().getEdad());
                System.out.println("Celular: " + lista.getParticipante().getCelular());
                System.out.println("Nro. Emergencia: " + lista.getParticipante().getNroEmergencia());
                System.out.println("Grupo Sanguíneo: " + lista.getParticipante().getGrupoSanguineo());
                System.out.println();
            }
            System.out.println("---------------------------------");
        }
    }

    private static void mostrarMontosCategorias(List<Categoria> categorias) {
        for (Categoria cat : categorias) {
            System.out.println("Categoria " + cat.getId() + ", monto total: " + cat.getMontoTotal());
        }
    }
}