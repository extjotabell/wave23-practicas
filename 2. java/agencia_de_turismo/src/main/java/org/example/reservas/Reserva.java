package org.example.reservas;

public abstract class Reserva {
    private final Double costo;
    private TipoReserva tipo;

    public Reserva(Double costo) {
        this.costo = costo;
    }

    public Double getCosto() {
        return costo;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }
}
