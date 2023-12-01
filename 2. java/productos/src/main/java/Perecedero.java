public class Perecedero extends Producto {
    private int diasPorCaducar;

    public int getDiasPorCaducar() { return diasPorCaducar; }
    public void setDiasPorCaducar(int diasPorCaducar) { this.diasPorCaducar = diasPorCaducar; }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
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
    public double calcular(int cantidad) {
        double precio = this.precio * cantidad;

        switch (diasPorCaducar) {
            case (1) -> precio /= 4;
            case (2) ->  precio /= 3;
            case (3) -> precio /= 2;
        }

        return precio;
    }
}
