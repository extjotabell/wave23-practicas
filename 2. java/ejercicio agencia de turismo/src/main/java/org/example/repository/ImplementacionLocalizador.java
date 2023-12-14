package org.example.repository;

import org.example.entities.Cliente;
import org.example.entities.Localizador;
import org.example.entities.Reserva;
import org.example.entities.TipoReserva;

import java.util.ArrayList;
import java.util.Optional;

public class ImplementacionLocalizador implements IGestionable<Localizador> {
    ArrayList<Localizador> localizadores = new ArrayList<>();

    @Override
    public String guardar(Localizador localizador) {
        if (localizador != null && !localizadores.contains(localizador)) {
            localizadores.add(localizador);
            return "Localizador agregado con éxito " + localizador;
        }

        return "No se pudo agregar el localizador";
    }

    @Override
    public ArrayList<Localizador> buscar(Localizador objeto) {
        return null;
    }

    @Override
    public int cantidadRegistros() {
        return localizadores.size();
    }

    // Asumiendo que los descuentos no son acumulables
    public double calcularTotal(Reserva reserva, Cliente cliente) {
        int localizadoresTotalesCliente = 0;
        int reservasHotelCliente = 0;
        int reservasBoletosCliente = 0;
        double total = 0;

        for (Localizador l : localizadores) {
            if (l.getCliente().equals(cliente)) {
                localizadoresTotalesCliente++;
            }

            for (Reserva r : l.getReservas()) {
                if (r.getTipo().equals(TipoReserva.HOTEL)) {
                    reservasHotelCliente++;
                }

                if (r.getTipo().equals(TipoReserva.BOLETOS)) {
                    reservasBoletosCliente++;
                }
            }
        }

        if (localizadoresTotalesCliente >= 2) {
            total = reserva.getCostoReserva() * 0.95;
        }

        if (reserva.getTipo().equals(TipoReserva.COMPLETA)) {
            total = reserva.getCostoReserva() * 0.9;
        }

        if (reservasHotelCliente >= 2 || reservasBoletosCliente >= 2) {
            total = reserva.getCostoReserva() * 0.95;
        }

        return total;
    }
}
