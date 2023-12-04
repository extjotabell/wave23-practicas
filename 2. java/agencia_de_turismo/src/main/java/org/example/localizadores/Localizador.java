package org.example.localizadores;

import org.example.clientes.Cliente;
import org.example.reservas.Reserva;
import org.example.reservas.ReservaCompleta;
import org.example.reservas.TipoReserva;

import java.util.List;

public class Localizador {
    private static int nextId;
    private final int id;
    private final List<Reserva> reservas;
    private Double costoTotal;

    public Localizador(List<Reserva> reservas) {
        this.id = ++ nextId;
        this.reservas = reservas;
        this.costoTotal = calcularCostoTotal(reservas);
    }

    public int getId() {
        return id;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    private static Double calcularCostoTotal(List<Reserva> reservas) {
        return reservas.stream().mapToDouble(Reserva::getCosto).sum();
    }

    public void aplicarDescuento(double porcentaje) {
        costoTotal -= costoTotal * porcentaje / 100;
    }

    public boolean incluyePaqueteCompleto() {
        return reservas.stream().anyMatch(reserva -> reserva.getTipo() == TipoReserva.COMPLETA);
    }
}
