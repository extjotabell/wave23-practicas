package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static Map<Integer, Inscripcion> inscriptos = new HashMap<>();
    static List<Categoria> categorias = new ArrayList<>();
    static List<Participante> participantes = new ArrayList<>();

    public static boolean validarEdad(int edad, int id){
        if (edad < 18 && id == 3){
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean validarInscripcion(int dni){
        boolean validacion = true;
        for (Map.Entry<Integer, Inscripcion> i: inscriptos.entrySet()) {
            Inscripcion inscripcion = i.getValue();
            if (inscripcion.participante.dni == dni) {
                System.out.println("El participante ya se encuentra inscripto en Categoria: " + inscripcion.categoria.nombre + ", Numero de Inscripcion: " + inscripcion.numero_inscripcion);
                validacion = false;
                break;
            }
        }
        return validacion;
    }

    public static void eliminarParticipante(int id){
        inscriptos.remove(id);
    }

    public static void listarInscriptos(){
        System.out.println("Lista de todos los inscriptos: ");
        for (Map.Entry<Integer, Inscripcion> i: inscriptos.entrySet()){
            Inscripcion in = i.getValue();
            System.out.println("Participante: " + in.participante.nombre);
            System.out.println("Categoria: " + in.categoria.nombre);
            System.out.println("Numero de inscripcion: " + in.numero_inscripcion);
            System.out.println("Monto: " + in.monto);
            System.out.println();
        }
    }

    public static void listarPorCategoria(int id){
        System.out.println("Lista de inscriptos por Categoria: ");
        for (Map.Entry<Integer, Inscripcion> i: inscriptos.entrySet()){
            Inscripcion in = i.getValue();
            if (in.categoria.id == id){
                System.out.println("Participante: " + in.participante.nombre);
                System.out.println("Categoria: " + in.categoria.nombre);
                System.out.println("Numero de inscripcion: " + in.numero_inscripcion);
                System.out.println("Monto: " + in.monto);
                System.out.println();
            }
        }
    }

    public static void inscribirParticipante(Participante participante, Categoria categoria){
        if (validarInscripcion(participante.dni)){
            if (validarEdad(participante.edad, categoria.id)) {
                Inscripcion inscripcion = new Inscripcion(categoria, participante);
                inscriptos.put(inscripcion.numero_inscripcion, inscripcion);
            }
            else{
                System.out.println("No se puede inscribir un participante menor de edad en las categorias avanzadas");
            }
        }
    }

    public static void crearCategoria(String nombre, String descripcion){
        categorias.add(new Categoria(nombre, descripcion));
    }

    public static void crearParticipante(int dni, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo){
        participantes.add(new Participante(dni, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo));
    }

    public static void listarCategorias(){
        System.out.println("Lista de Categorias: ");
        for (Categoria categoria : categorias){
            System.out.println(categoria.id);
            System.out.println(categoria.nombre);
            System.out.println(categoria.descripcion);
        }
    }

    public static void listarParticipantes(){
        System.out.println("Lista de Participantes: ");
        for (Participante participante : participantes){
            System.out.println(participante.dni);
            System.out.println(participante.nombre + " " + participante.apellido);
            System.out.println(participante.edad);
            System.out.println(participante.celular);
            System.out.println(participante.numero_emergencia);
            System.out.println(participante.grupo_sanguineo);
        }
    }

    public static void calculoRecaudacion(){
        double recaudacion_chico = 0, recaudacion_medio = 0, recaudacion_avanzado = 0, recaudacion_total = 0;
        System.out.println("Recaudacion");
        for (Map.Entry<Integer, Inscripcion> i: inscriptos.entrySet()){
            Inscripcion in = i.getValue();
            recaudacion_total += in.monto;
            switch (in.categoria.id){
                case 1:
                    recaudacion_chico += in.monto;
                    break;
                case 2:
                    recaudacion_medio += in.monto;
                    break;
                case 3:
                    recaudacion_avanzado += in.monto;
                    break;
            }
        }

        System.out.println("Circuito Chico: " + recaudacion_chico);
        System.out.println("Circuito Medio: " + recaudacion_medio);
        System.out.println("Circuito Avanzado: " + recaudacion_avanzado);
        System.out.println("Total: " + recaudacion_total);
    }

    public static void main(String[] args) {
        //Categorias
        crearCategoria("Circuito Chico", "2 km por selva y arroyos.");
        crearCategoria("Circuito Medio", "5 km por selva, arroyos y barro.");
        crearCategoria("Circuito Avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");
        listarCategorias();

        //Participantes
        crearParticipante(12345678, "Lucas", "Salerno", 29, "234893423", "338462833", "0+");
        crearParticipante(12345690, "Juan", "Rojas", 30, "2344293423", "338462833", "0+");
        crearParticipante(12345667, "Maria", "Perez", 16, "2343293423", "338462833", "0+");
        listarParticipantes();

        inscribirParticipante(participantes.get(0), categorias.get(0));
        inscribirParticipante(participantes.get(1), categorias.get(1));
        inscribirParticipante(participantes.get(2), categorias.get(1));

        calculoRecaudacion();

        listarPorCategoria(categorias.get(1).id);

        eliminarParticipante(2);

        listarInscriptos();

        calculoRecaudacion();

    }

}