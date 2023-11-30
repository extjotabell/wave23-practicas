package main;

public class Perecedero extends Producto {

    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero: \n" +
                "Días por caducar: " + this.diasPorCaducar;
    }

    @Override
    public double calcular(int cantDeProductos) {
        double precio = super.calcular(cantDeProductos);

        if (this.diasPorCaducar == 1) {
            precio = precio / 4;
        }
        else if (this.diasPorCaducar == 2) {
            precio = precio / 3;
        }
        else if (this.diasPorCaducar == 3) {
            precio = precio / 2;
        }

        return precio;
    }
}
