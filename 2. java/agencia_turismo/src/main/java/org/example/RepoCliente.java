package org.example;

import java.util.ArrayList;
import java.util.List;

public class RepoCliente {
    List<Localizador> localizadores;

    public RepoCliente() {
        localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
        aplicarDescuentosReserva(localizador);
        System.out.println(localizador);
    }

    private long cantLocalizadoresPorCliente(int idCliente) {
        return localizadores.stream().filter(x -> x.getCliente().getIdCliente() == idCliente).count();
    }

    private boolean clienteTienePaqueteCompleto(Localizador localizador) {
        return localizador.getReservas().stream().anyMatch(Reserva::esPaqueteCompleto);
    }

    private boolean clienteTiene2HotelesOBoletos(Localizador loc) {
        long cantHotel = loc.getReservas().stream().filter(Reserva::isTieneHotel).count();
        long cantBoletos = loc.getReservas().stream().filter(Reserva::isTieneboletos).count();

        return cantHotel >= 2 || cantBoletos >= 2;
    }

    public void aplicarDescuentosReserva(Localizador localizador) {
        double descuento = 0;

        if (!localizador.getCliente().getAplicaDescuento()) {
            localizador.getCliente().setAplicaDescuento(cantLocalizadoresPorCliente(localizador.getCliente().getIdCliente()) >= 2);
        }
        if (clienteTienePaqueteCompleto(localizador)) {
            descuento = localizador.getTotal() * 0.10d;
        }

        if (clienteTiene2HotelesOBoletos(localizador)) {
            descuento = localizador.getTotal() * 0.05d;
        }

        if (localizador.getCliente().getAplicaDescuento()) {
            descuento = localizador.getTotal() * 0.05d;
        }
        localizador.setTotal(localizador.getTotal() - descuento);
    }
}
