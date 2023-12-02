package org.example;

public class Perecedero extends Producto{

    int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double valor = 0.0;
        switch (diasPorCaducar){
            case 1 ->{
                valor = (this.getPrecio() * cantidadDeProductos) / 4;
            }
            case 2 ->{
                valor = (this.getPrecio() * cantidadDeProductos) / 3;
            }
            case 3 ->{
                valor = (this.getPrecio() * cantidadDeProductos) / 2;
            }
            default -> valor = this.getPrecio() * cantidadDeProductos;
        }
        return valor;
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
}
