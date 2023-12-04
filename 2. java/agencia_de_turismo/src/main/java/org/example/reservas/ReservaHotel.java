package org.example.reservas;

public class ReservaHotel extends Reserva {
    public ReservaHotel(Double costo) {
        super(costo);
        setTipo(TipoReserva.HOTEL);
    }
}
