package org.example;

public class Perecedero extends Producto{

    int diasPorCaducar;

    public Perecedero(String nombre, Double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    };

    @Override
    public Double calcular(int cantidadDeProductos){
        Double modificador = 1.0;
        switch (this.diasPorCaducar){
            case 1:
                modificador = (1.0/4.0);
                break;
            case 2:
                modificador = (1.0/3.0);
                break;
            case 3:
                modificador = (1.0/2.0);
                break;
        }
        return (super.calcular(cantidadDeProductos)*modificador);
    };

    @Override
    public String toString() {
        return "Perecedero " +
                "diasPorCaducar=" + diasPorCaducar +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio;
    }
}
