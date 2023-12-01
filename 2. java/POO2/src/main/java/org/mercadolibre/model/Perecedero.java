package org.mercadolibre.model;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioActual = precio * cantidadDeProductos;

        switch (diasPorCaducar){
            case 1->{precioActual = precioActual/4;}
            case 2->{precioActual = precioActual/3;}
            case 3->{precioActual = precioActual/2;}
        }
        return precioActual;
    }

    @Override
    public String toString() {
        return "Alimento perecedero con " + diasPorCaducar +  " días para la fecha de vencimiento.\n";
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }
}
