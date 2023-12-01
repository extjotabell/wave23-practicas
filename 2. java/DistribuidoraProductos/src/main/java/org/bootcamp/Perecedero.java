package org.bootcamp;

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
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidad){
        if(this.diasPorCaducar == 1){
            return cantidad * (this.precio / 4);
        }
        else if (this.diasPorCaducar == 2){
            return cantidad * (this.precio / 3);
        }
        else if (this.diasPorCaducar == 3){
            return cantidad * (this.precio / 2);
        }
        else{
            return cantidad * this.precio;
        }
    }

}
