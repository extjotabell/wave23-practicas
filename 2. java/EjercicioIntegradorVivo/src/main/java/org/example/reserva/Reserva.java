package org.example.reserva;

public class Reserva {

    private String descripcion;
    private TipoReserva tipo;
    private Double precio;

    public Reserva(TipoReserva tipo, Double precio, String descripcion) {
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "descripcion='" + descripcion + '\'' +
                ", tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }

    public Double getPrecio() {
        return precio;
    }
}
