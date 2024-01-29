package org.example.model;

public class DescuentoReserva implements Decorator{
    private Decorator decorador;
    private double descuento;

    public DescuentoReserva(Decorator reserva, double descuento) {
        this.decorador = reserva;
        this.descuento = descuento;
    }

    @Override
    public double getTotal() {
        return decorador.getTotal()*(1-descuento);
    }

    @Override
    public String toString() {
        return "DescuentoReserva{" +
                "decorador=" + decorador +
                ", descuento=" + descuento +
                '}';
    }
}
