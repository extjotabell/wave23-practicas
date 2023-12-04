package main;

import java.util.*;

public class Localizador {
    private Cliente cliente;
    private List<Reserva> reservas;
    private double totalReservasSinDesc;
    private double totalDescuentos;

    public Localizador(Cliente cliente, List<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;

        int hotel = 0, comida = 0, boleto = 0, transporte = 0;
        double precioHoteles = 0, precioBoleto = 0;

        for (Reserva r : this.reservas) {
            this.totalReservasSinDesc += r.getPrecio();

            if (r.getNombre() == "Hotel") {
                hotel += 1;
                precioHoteles += r.getPrecio();
            }
            else if (r.getNombre() == "Comida") {
                comida += 1;
            }
            else if (r.getNombre() == "Boleto de viaje") {
                boleto += 1;
                precioBoleto += r.getPrecio();
            }
            else if (r.getNombre() == "Transporte") {
                transporte += 1;
            }
        }

        if (hotel == 1 && comida == 1 && boleto == 1 && transporte == 1) {
            this.totalDescuentos += this.totalReservasSinDesc * 0.1;
        }
        else if (hotel >= 2 || boleto >= 2) {
            this.totalDescuentos += (precioHoteles + precioBoleto) * 0.05;
        }
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setDescuentos(double valor) {
        this.totalDescuentos += valor;
    }

    public double getTotalReservasSinDesc() {
        return this.totalReservasSinDesc;
    }

    public double getTotalDescuentos() {
        return this.totalDescuentos;
    }
}
