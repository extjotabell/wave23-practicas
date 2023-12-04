package org.example;

import org.example.modelo.*;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1", "Juan", "Perez");
        Cliente cliente2 = new Cliente("2", "Pedro", "Gomez");
        Reserva reserva1 = new Reserva("1", TipoReserva.VUELO, 100.0);
        Reserva reserva2 = new Reserva("2", TipoReserva.HOTEL, 200.0);
        Reserva reserva3 = new Reserva("3", TipoReserva.COMIDA, 300.0);


        Agencia agencia = new Agencia();
        agencia.getLocalizador().agregar(new Localizador("1", cliente1));
        agencia.getLocalizador().obtenerPorId("1").getReservas().add(reserva1);
        agencia.getLocalizador().obtenerPorId("1").getReservas().add(reserva2);
        agencia.getLocalizador().obtenerPorId("1").calcularTotal();

        System.out.println("\nLocalizador 1");
        System.out.println(agencia.getLocalizador().obtenerPorId("1"));

        agencia.getLocalizador().agregar(new Localizador("2", cliente2));
        agencia.getLocalizador().obtenerPorId("2").getReservas().add(reserva3);
        agencia.getLocalizador().obtenerPorId("2").calcularTotal();

        agencia.getLocalizador().agregar(new Localizador("3", cliente1));
        agencia.getLocalizador().obtenerPorId("3").getReservas().add(reserva3);

        System.out.println("\nTodos los localizadores");
        System.out.println(agencia.getLocalizador().obtenerTodos());

        System.out.println("\nObtener por Cliente");
        System.out.println(agencia.getLocalizador().obtenerTodosPorIdCliente("1"));

    }
}