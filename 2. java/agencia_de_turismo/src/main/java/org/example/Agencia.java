package org.example;

import org.example.clientes.Cliente;
import org.example.clientes.RepositorioCliente;
import org.example.localizadores.Localizador;
import org.example.localizadores.RepositorioLocalizador;
import org.example.reservas.*;

import java.util.List;

public class Agencia {
    private final RepositorioCliente repositorioCliente;
    private final RepositorioLocalizador repositorioLocalizador;

    public Agencia() {
        this.repositorioCliente = new RepositorioCliente();
        this.repositorioLocalizador = new RepositorioLocalizador();
    }

    public Cliente agregarCliente(String dni) {
        Cliente cliente = new Cliente(dni);
        repositorioCliente.agregarCliente(cliente);
        return cliente;
    }

    public Cliente agregarCliente(String dni, String nombre) {
        Cliente cliente = new Cliente(dni, nombre);
        repositorioCliente.agregarCliente(cliente);
        return cliente;
    }

    public Localizador agregarLocalizador(String dni, Reserva...  reservas) {
        Cliente cliente = repositorioCliente.buscarCliente(dni);
        if (cliente == null)
            cliente = agregarCliente(dni);

        Localizador localizador = new Localizador(List.of(reservas));

        cliente.agregarLocalizador(localizador);
        repositorioLocalizador.agregarLocalizador(localizador);

        aplicarDescuento(cliente, localizador);

        return localizador;
    }

    public Localizador agregarLocalizador(Cliente cliente, Reserva...  reservas) {
        Localizador localizador = new Localizador(List.of(reservas));

        cliente.agregarLocalizador(localizador);
        repositorioLocalizador.agregarLocalizador(localizador);

        aplicarDescuento(cliente, localizador);

        return localizador;
    }

    public Reserva crearReserva(TipoReserva tipo, Double costo) {
        return switch (tipo) {
            case COMPLETA -> new ReservaCompleta(costo);
            case HOTEL -> new ReservaHotel(costo);
            case VUELO -> new ReservaVuelo(costo);
        };
    }

    private void aplicarDescuento(Cliente cliente, Localizador localizador) {
        if (cliente.getLocalizadores().size() >= 2)
            localizador.aplicarDescuento(5);

        if (localizador.incluyePaqueteCompleto())
            localizador.aplicarDescuento(10);

        long reservasTipoVuelo = localizador.getReservas().stream()
                .filter(reserva -> reserva.getTipo() == TipoReserva.VUELO).count();

        long reservasTipoHotel = localizador.getReservas().stream()
                .filter(reserva -> reserva.getTipo() == TipoReserva.HOTEL).count();

        if (reservasTipoVuelo >= 2 || reservasTipoHotel >= 2)
            localizador.aplicarDescuento(5);
    }
}
