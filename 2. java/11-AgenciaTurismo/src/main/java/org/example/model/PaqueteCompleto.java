package org.example.model;

import java.util.List;

public class PaqueteCompleto extends Paquete{

    public PaqueteCompleto(String id, Cliente cliente) {
        super(id, cliente, List.of(
                new Reserva("1", cliente, 400, TipoReserva.COMIDA),
                new Reserva("2", cliente, 100, TipoReserva.BOLETO),
                new Reserva("3", cliente, 800, TipoReserva.HOTEL),
                new Reserva("4", cliente, 500, TipoReserva.TRANSPORTE)
        ));
        setTipoReserva(TipoReserva.PAQUETE_COMPLETO);

    }

}
