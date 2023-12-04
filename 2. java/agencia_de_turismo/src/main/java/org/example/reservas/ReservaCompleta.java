package org.example.reservas;

public class ReservaCompleta extends Reserva {
    public ReservaCompleta(Double costo) {
        super(costo);
        setTipo(TipoReserva.COMPLETA);
    }
}
