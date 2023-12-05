package org.example;

public class Reserva {
    private int codigo;
    private TipoProducto tipo;
    private double precio;

    public Reserva(int codigo, TipoProducto tipo, double precio) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoProducto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProducto tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "\tCodigo: " + codigo + "\n" +
                "\tTipo: " + tipo + "\n" +
                "\tPrecio: " + precio + "\n";
    }
}
