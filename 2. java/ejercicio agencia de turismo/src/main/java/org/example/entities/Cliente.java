package org.example.entities;

import java.util.ArrayList;

public class Cliente {
    private int dni;
    private String nombre;

    private ArrayList<Reserva> reservas;

    public Cliente(int dni, String nombre, ArrayList<Reserva> reservas) {
        this.dni = dni;
        this.nombre = nombre;
        this.reservas = reservas;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", reservas=" + reservas +
                '}';
    }
}
