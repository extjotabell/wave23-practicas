package org.example;

import org.example.modelo.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1", "Juan", "Perez");
        Cliente cliente2 = new Cliente("2", "Pedro", "Gomez");
        Reserva reserva1 = new Reserva("1", TipoReserva.VUELO, 100.0);
        Reserva reserva2 = new Reserva("2", TipoReserva.HOTEL, 200.0);
        Reserva reserva3 = new Reserva("3", TipoReserva.COMIDA, 300.0);
        Reserva reserva4 = new Reserva("4", TipoReserva.TRANSPORTE, 400.0);

        Agencia agencia = new Agencia();

        //Localizador 1
        agencia.getLocalizador().agregar(new Localizador("1", cliente1));
        agencia.getLocalizador().obtenerPorId("1").getReservas().add(reserva1);
        agencia.getLocalizador().obtenerPorId("1").getReservas().add(reserva2);
        calcularDescuento(agencia, "1");
        System.out.println("\nLocalizador 1");
        System.out.println(agencia.getLocalizador().obtenerPorId("1"));

        //Localizador 2
        agencia.getLocalizador().agregar(new Localizador("2", cliente2));
        agencia.getLocalizador().obtenerPorId("2").getReservas().add(reserva3);
        calcularDescuento(agencia, "2");
        System.out.println("\nLocalizador 2");
        System.out.println(agencia.getLocalizador().obtenerPorId("2"));

        //Localizador 3
        agencia.getLocalizador().agregar(new Localizador("3", cliente1));
        agencia.getLocalizador().obtenerPorId("3").getReservas().add(reserva3);
        calcularDescuento(agencia, "3");
        System.out.println("\nLocalizador 3");
        System.out.println(agencia.getLocalizador().obtenerPorId("3"));

        //Localizador 4
        agencia.getLocalizador().agregar(new Localizador("4", cliente1));
        agencia.getLocalizador().obtenerPorId("4").getReservas().add(reserva4);
        agencia.getLocalizador().obtenerPorId("4").getReservas().add(reserva2);
        calcularDescuento(agencia, "4");
        System.out.println("\nLocalizador 4");
        System.out.println(agencia.getLocalizador().obtenerPorId("4"));

        //Prueba Paquete Completo
        agencia.getLocalizador().agregar(new Localizador("5", cliente2));
        agencia.getLocalizador().obtenerPorId("5").getReservas().add(reserva1);
        agencia.getLocalizador().obtenerPorId("5").getReservas().add(reserva2);
        agencia.getLocalizador().obtenerPorId("5").getReservas().add(reserva3);
        agencia.getLocalizador().obtenerPorId("5").getReservas().add(reserva4);
        calcularDescuento(agencia, "5");
        System.out.println("\nLocalizador 5");
        System.out.println(agencia.getLocalizador().obtenerPorId("5"));

        System.out.println("\nTodos los localizadores");
        System.out.println(agencia.getLocalizador().obtenerTodos());

        System.out.println("\nObtener por Cliente");
        System.out.println(agencia.getLocalizador().obtenerTodosPorIdCliente("1"));

    }

    public static void calcularDescuento(Agencia agencia, String idLocalizador) {
        System.out.println("\nEntró a calcular descuento del Localizador " + idLocalizador);
        String idCliente = agencia.getLocalizador().obtenerPorId(idLocalizador).getCliente().getId();
        List<Localizador> listaLocalizadoresCliente = agencia.getLocalizador().obtenerTodosPorIdCliente(idCliente);

        Localizador localizador = agencia.getLocalizador().obtenerPorId(idLocalizador);

        boolean poseePaqueteCompleto =
                localizador.tieneTipoReserva(TipoReserva.VUELO) &&
                        localizador.tieneTipoReserva(TipoReserva.HOTEL) &&
                        localizador.tieneTipoReserva(TipoReserva.COMIDA) &&
                        localizador.tieneTipoReserva(TipoReserva.TRANSPORTE);

        if (poseePaqueteCompleto) {
            System.out.println("Posee paquete completo");
            agencia.getLocalizador().obtenerPorId(idLocalizador).calcularTotal(0.1);
        } else if (listaLocalizadoresCliente.size() > 2) {
            System.out.println("Posee más de 2 localizadores");
            agencia.getLocalizador().obtenerPorId(idLocalizador).calcularTotal(0.05);
        }else {
            System.out.println("No posee paquete completo ni más de 2 localizadores");
            agencia.getLocalizador().obtenerPorId(idLocalizador).calcularTotal(0.0);
        }

    }
}