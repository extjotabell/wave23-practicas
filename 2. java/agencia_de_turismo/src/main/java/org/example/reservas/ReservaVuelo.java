package org.example.reservas;

public class ReservaVuelo extends Reserva {
    public ReservaVuelo(Double costo) {
        super(costo);
        setTipo(TipoReserva.VUELO);
    }
}
