package org.example.model;

import java.util.List;

public class Paquete extends Reserva{
    private List<Reserva> reservas;

    public Paquete(String id, Cliente cliente, List<Reserva> reservas) {
        super(id, cliente, reservas.stream().mapToDouble(reserva-> reserva.getTotal()).sum(),TipoReserva.PAQUETE);
        this.reservas=reservas;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }
}
