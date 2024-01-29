package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Cliente c1 = new Cliente("1", "Pepe");

        Agencia agencia = new Agencia();
        agencia.getClientes().add(c1);
        agencia.getClientes().showAll();

        agencia.realizarReserva(c1, new PaqueteCompleto("1",c1));

        agencia.realizarReserva(c1, new Paquete("2", c1, List.of(
                new Reserva("6", c1, 400, TipoReserva.BOLETO),
                new Reserva("7", c1, 200, TipoReserva.BOLETO),
                new Reserva("8", c1, 10000, TipoReserva.HOTEL),
                new Reserva("9", c1, 4400, TipoReserva.HOTEL)
        )));

        agencia.realizarReserva(c1, new Reserva("10", c1, 400, TipoReserva.COMIDA));

    }
}