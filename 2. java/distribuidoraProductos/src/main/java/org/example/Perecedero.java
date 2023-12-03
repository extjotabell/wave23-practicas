package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

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
    public double calcular(double cantidadDeProductos){
        int reduccionPrecio;
        if(this.diasPorCaducar == 1) {
            reduccionPrecio = 4;
        } else if (this.diasPorCaducar == 2){
            reduccionPrecio = 3;
        } else if(this.diasPorCaducar == 3) {
            reduccionPrecio = 2;
        } else {
            reduccionPrecio = 1;
        }
        return (super.precio * cantidadDeProductos) / reduccionPrecio;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
