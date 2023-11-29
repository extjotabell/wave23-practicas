package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Categoria cat1 = new Categoria("Circuito chico", "2 km por selva y arroyos.", true, 1500, 1300);
        Categoria cat2 = new Categoria("Circuito medio", "5 km por selva, arroyos y barro.", true, 2300, 2000);
        Categoria cat3 = new Categoria("Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra.", false, 2800);

        Map<Categoria, List<Inscripcion>> inscripciones = new HashMap<>();
        List<Categoria> categorias = new ArrayList<>(Arrays.asList(cat1, cat2, cat3));

        inscripciones.put(cat1, new ArrayList<>());
        inscripciones.put(cat2, new ArrayList<>());
        inscripciones.put(cat3, new ArrayList<>());


        boolean quit = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Presiona la opcion que quieras realizar: ");
            System.out.println(
                    """
                            1. Realizar inscripcion
                            2. Realizar desinscripcion
                            3. Listar participantes por categoria
                            4. Listar monto recaudado por categoria
                            5. Listar monto total
                            6. Salir"""
            );

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> realizarInscripcion(categorias, inscripciones);
                case 2 -> realizarDesinscripcion(categorias, inscripciones);
                case 3 -> listarPorCategoria(categorias, inscripciones);
                case 4 -> listarMontoPorCategoria(categorias, inscripciones);
                case 5 -> listarMontoTotal(inscripciones);
                case 6 -> quit = true;
                default -> System.out.println("Opcion invalida.");
            }
        } while (!quit);

    }

    private static void realizarInscripcion(List<Categoria> categorias, Map<Categoria, List<Inscripcion>> inscripciones) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre: ");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido: ");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Seleccione la categoria a participar: ");

        for (int i = 0; i < categorias.size(); i++)
            System.out.println((i + 1) + ". " + categorias.get(i).getNombre());

        int opcionCat = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = categorias.get(opcionCat - 1);
        Participante p = new Participante(nombre, apellido, edad);

        Inscripcion nuevaInscripcion = new Inscripcion(p, cat);
        inscripciones.get(cat).add(nuevaInscripcion);

        System.out.println("Monto total a abonar: " + nuevaInscripcion.getMontoTotal());
    }

    private static void realizarDesinscripcion(List<Categoria> categorias, Map<Categoria, List<Inscripcion>> inscripciones) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la categoria: ");

        for (int i = 0; i < categorias.size(); i++)
            System.out.println((i + 1) + ". " + categorias.get(i).getNombre());

        int opcionCat = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = categorias.get(opcionCat - 1);

        System.out.println("Seleccione que inscripcion desea cancelar: ");

        for (int i = 0; i < inscripciones.get(cat).size(); i++)
            System.out.println((i + 1) + ". " + inscripciones.get(cat).get(i).getParticipante());


        int opcionInsc = scanner.nextInt();
        scanner.nextLine();

        inscripciones.get(cat).remove(opcionInsc - 1);

        System.out.println("Participante desinscrito con exito.");
    }

    private static void listarPorCategoria(List<Categoria> categorias, Map<Categoria, List<Inscripcion>> inscripciones) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la categoria: ");

        for (int i = 0; i < categorias.size(); i++)
            System.out.println((i + 1) + ". " + categorias.get(i).getNombre());

        int opcionCat = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = categorias.get(opcionCat - 1);

        for (Inscripcion i : inscripciones.get(cat))
            System.out.println(i.getParticipante());
    }

    private static void listarMontoPorCategoria(List<Categoria> categorias, Map<Categoria, List<Inscripcion>> inscripciones) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la categoria: ");

        for (int i = 0; i < categorias.size(); i++)
            System.out.println((i + 1) + ". " + categorias.get(i).getNombre());

        int opcionCat = scanner.nextInt();
        scanner.nextLine();

        Categoria cat = categorias.get(opcionCat - 1);

        int total = 0;
        for (Inscripcion i : inscripciones.get(cat))
            total += i.getMontoTotal();

        System.out.println("El monto total de la categoria es de: " + total);
    }

    private static void listarMontoTotal(Map<Categoria, List<Inscripcion>> inscripciones) {
        int total = 0;

        for (Categoria cat : inscripciones.keySet())
            for (Inscripcion i : inscripciones.get(cat))
                total += i.getMontoTotal();

        System.out.println("El monto total de la categoria es de: " + total);
    }
}

class Participante {
    private static int nextId = 1;
    private final int id;
    private final String nombre;
    private final String apellido;
    private final int edad;

    public Participante(String nombre, String apellido, int edad) {
        this.id = nextId ++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Participante{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}

class Inscripcion {
    private static int nextId = 1;
    private final int id;
    private final Participante participante;
    private final Categoria categoria;
    private final int montoTotal;
    private final boolean inscripcionValida;

    public Inscripcion(Participante participante, Categoria categoria) {
        if (!categoria.isPermiteMenores() && participante.getEdad() < 18) {
            inscripcionValida = false;
            throw new IllegalStateException("Participantes menores de 18 años no pueden participar en este circuito.");
        }
        inscripcionValida = true;
        this.id = nextId ++;
        this.participante = participante;
        this.categoria = categoria;
        this.montoTotal = calcularMonto(participante, categoria);
    }

    public int getId() {
        return id;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public int getMontoTotal() {
        return montoTotal;
    }

    public boolean getInscripcionValida() {
        return inscripcionValida;
    }

    private static int calcularMonto(Participante par, Categoria cat) {
        return par.getEdad() < 18 ? cat.getPrecioMenores() : cat.getPrecioMayores();
    }
}

class Categoria {
    private static int nextId = 1;
    private final int id;
    private final String nombre;
    private final String descripcion;
    private final boolean permiteMenores;
    private final int precioMayores;
    private final int precioMenores;

    public Categoria(String nombre, String descripcion, boolean permiteMenores, int precioMayores, int precioMenores) {
        this.id = nextId ++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.permiteMenores = permiteMenores;
        this.precioMayores = precioMayores;
        this.precioMenores = precioMenores;
    }

    public Categoria(String nombre, String descripcion, boolean permiteMenores, int precioMayores) {
        this.id = nextId ++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.permiteMenores = permiteMenores;
        this.precioMayores = precioMayores;
        this.precioMenores = 0;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isPermiteMenores() {
        return permiteMenores;
    }

    public int getPrecioMayores() {
        return precioMayores;
    }

    public int getPrecioMenores() {
        return precioMenores;
    }
}