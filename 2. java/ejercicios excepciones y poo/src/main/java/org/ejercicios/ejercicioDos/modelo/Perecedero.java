package org.ejercicios.ejercicioDos.modelo;

public class Perecedero extends Producto{

    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
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

}
