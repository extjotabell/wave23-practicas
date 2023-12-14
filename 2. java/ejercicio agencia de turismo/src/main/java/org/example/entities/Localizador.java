package org.example.entities;

import org.example.repository.IGestionable;

import java.util.ArrayList;

public class Localizador {
    private ArrayList<Reserva> reservas;
    private Cliente cliente;
    private double total;

    public Localizador(ArrayList<Reserva> reservas, Cliente cliente, double total) {
        this.reservas = reservas;
        this.cliente = cliente;
        this.total = total;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "reservas=" + reservas +
                ", cliente=" + cliente +
                ", total=" + total +
                '}';
    }
}
