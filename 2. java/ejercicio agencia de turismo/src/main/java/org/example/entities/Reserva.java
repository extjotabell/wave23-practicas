package org.example.entities;

public class Reserva {
    private int idReserva;
    private TipoReserva tipo;
    private double costoReserva;

    public Reserva(int idReserva, TipoReserva tipo, double costoReserva) {
        this.idReserva = idReserva;
        this.tipo = tipo;
        this.costoReserva = costoReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public double getCostoReserva() {
        return costoReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "idReserva=" + idReserva +
                ", tipo=" + tipo +
                ", costoReserva=" + costoReserva +
                '}';
    }
}
