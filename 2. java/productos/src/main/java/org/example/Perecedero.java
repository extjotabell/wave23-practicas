package org.example;

public class Perecedero extends Producto{
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
                '}';
    }
    @Override
    public double calcular(int cantidadProductos){
        double precioFinal = this.getPrecio() * cantidadProductos;
        return precioFinal - descuentoSegunDiasPorCaducar(precioFinal) ;
    }

    private double descuentoSegunDiasPorCaducar(double precioFinal) {
        switch (diasPorCaducar){
            case 1 -> {
                return precioFinal * 1/4;
            }
            case 2 -> {
                return precioFinal * 1/3;
            }
            case 3 -> {
                return precioFinal * 1/2;
            }
            default -> {
                return 0;
            }
        }
    }
}
