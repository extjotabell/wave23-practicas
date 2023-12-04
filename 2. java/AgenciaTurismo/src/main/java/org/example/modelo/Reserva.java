package org.example.modelo;

import org.example.interfaces.Modelo;

public class Reserva implements Modelo {

    private final String id;
    private TipoReserva tipoReserva;
    private Double precio;

    public Reserva(String id, TipoReserva tipoReserva, Double precio) {
        this.id = id;
        this.tipoReserva = tipoReserva;
        this.precio = precio;
    }

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", tipoReserva=" + tipoReserva +
                ", precio=" + precio +
                '}';
    }

    @Override
    public String getId() {
        return this.id;
    }
}
