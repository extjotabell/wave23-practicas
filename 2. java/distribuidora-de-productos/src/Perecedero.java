package org.example;

public class Perecedero extends Producto {
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantProductos){
        return switch (this.diasPorCaducar) {
            case 1 -> super.calcular(cantProductos) / 4;
            case 2 -> super.calcular(cantProductos) / 3;
            case 3 -> super.calcular(cantProductos) / 2;
            default -> super.calcular(cantProductos);
        };
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
