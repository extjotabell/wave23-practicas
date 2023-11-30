public class Perecedero extends Producto {

    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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
    public double calcular(int cantidad) {

        double precioFinal;

        if(diasPorCaducar == 1){
            precioFinal = (precio * cantidad) / 4;
            System.out.println((precio * cantidad) / 4);
        }else if(diasPorCaducar == 2){
            precioFinal = (precio * cantidad) / 3;
            System.out.println((precio * cantidad) / 3);
        }else if(diasPorCaducar == 3){
            precioFinal = (precio * cantidad) / 2;
            System.out.println((precio * cantidad) / 2);
        }else{
            precioFinal = (precio * cantidad);
            System.out.println((precio * cantidad));
        }

        return precioFinal;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Precio: %f, Dias por caducar: %d", this.nombre, this.precio, this.diasPorCaducar);
    }
}
