package org.example.modelo;

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                "} " + super.toString();
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        double calculo = super.calcular(cantidadDeProductos);
        return switch (this.diasPorCaducar) {
            case 1 -> calculo / 4;
            case 2 -> calculo / 3;
            case 3 -> calculo / 2;
            default -> calculo;
        };
    }

}
