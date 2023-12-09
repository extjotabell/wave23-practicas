import modelo.*;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Agencia agencia = new Agencia();

        Cliente cliente1 = new Cliente("1", "Juan", "Perez");
        Cliente cliente2 = new Cliente("2", "Pedro", "Gomez");

        Reserva reserva1 = new Reserva("1", TipoReserva.VUELO, 100.0);
        Reserva reserva2 = new Reserva("2", TipoReserva.HOTEL, 200.0);
        Reserva reserva3 = new Reserva("3", TipoReserva.COMIDA, 300.0);
        Reserva reserva4 = new Reserva("4", TipoReserva.TRANSPORTE, 400.0);

        crearLocalizador(agencia, "1", cliente1, reserva1, reserva2);
        crearLocalizador(agencia, "2", cliente2, reserva3);
        crearLocalizador(agencia, "3", cliente1, reserva3);
        crearLocalizador(agencia, "4", cliente1, reserva4, reserva2);
        crearLocalizador(agencia, "5", cliente2, reserva1, reserva2, reserva3, reserva4);

        imprimirLocalizador(agencia, "1");
        imprimirLocalizador(agencia, "2");
        imprimirLocalizador(agencia, "3");
        imprimirLocalizador(agencia, "4");
        imprimirLocalizador(agencia, "5");

        imprimirTodosLocalizadores(agencia);
        imprimirLocalizadoresPorCliente(agencia, "1");
    }

    public static void crearLocalizador(Agencia agencia, String id, Cliente cliente, Reserva... reservas) {
        Localizador localizador = new Localizador(id, cliente);
        for (Reserva reserva : reservas) {
            localizador.getReservas().add(reserva);
        }
        agencia.getLocalizador().agregar(localizador);
        calcularDescuento(agencia, id);
    }

    public static void imprimirLocalizador(Agencia agencia, String id) {
        System.out.println("\nLocalizador " + id);
        System.out.println(agencia.getLocalizador().obtenerPorId(id));
    }

    public static void imprimirTodosLocalizadores(Agencia agencia) {
        System.out.println("\nTodos los localizadores");
        System.out.println(agencia.getLocalizador().obtenerTodos());
    }

    public static void imprimirLocalizadoresPorCliente(Agencia agencia, String idCliente) {
        System.out.println("\nObtener por Cliente " + idCliente);
        System.out.println(agencia.getLocalizador().obtenerTodosPorIdCliente(idCliente));
    }

    public static void calcularDescuento(Agencia agencia, String idLocalizador) {
        System.out.println("\nEntró a calcular descuento del Localizador " + idLocalizador);

        Localizador localizador = agencia.getLocalizador().obtenerPorId(idLocalizador);

        boolean poseePaqueteCompleto =
                localizador.tieneTipoReserva(TipoReserva.VUELO) &&
                        localizador.tieneTipoReserva(TipoReserva.HOTEL) &&
                        localizador.tieneTipoReserva(TipoReserva.COMIDA) &&
                        localizador.tieneTipoReserva(TipoReserva.TRANSPORTE);

        if (poseePaqueteCompleto) {
            System.out.println("Posee paquete completo");
            localizador.calcularTotal(0.1);
        } else {
            List<Localizador> listaLocalizadoresCliente = agencia.getLocalizador().obtenerTodosPorIdCliente(localizador.getCliente().getId());
            if (listaLocalizadoresCliente.size() > 2) {
                System.out.println("Posee más de 2 localizadores");
                localizador.calcularTotal(0.05);
            } else {
                System.out.println("No posee paquete completo ni más de 2 localizadores");
                localizador.calcularTotal(0.0);
            }
        }
    }
}