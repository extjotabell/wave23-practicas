package org.example;

public class Perecedero extends Producto {
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
    public double calcular(int cantidadDeProductos){
        double precio_perecedero = 0;
        switch (diasPorCaducar){
            case 1 -> {
                precio_perecedero =  (precio/4) * cantidadDeProductos;
            }
            case 2 -> {
                precio_perecedero = (precio/3) * cantidadDeProductos;

            }
            case 3 -> {
                precio_perecedero = (precio/2) * cantidadDeProductos;
            }
        }
        return precio_perecedero;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
