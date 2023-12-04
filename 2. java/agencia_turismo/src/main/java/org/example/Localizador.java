package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private double total;
    List<Reserva> reservas;

    public List<Reserva> getReservas() {
        return reservas;
    }

    public long sizeReservas() {
        return reservas.size();
    }

    public double getTotal() {
        return total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private String imprimirReservas() {
        return reservas.stream().map(Reserva::toString).collect(Collectors.joining(" | "));
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Localizador(Cliente cliente, double total, List<Reserva> reservas) {
        this.cliente = cliente;
        this.total = total;
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Localizador { " +
                "cliente = " + cliente +
                ", total = " + total +
                ", reservas = " + imprimirReservas() +
                " } ";
    }
}
