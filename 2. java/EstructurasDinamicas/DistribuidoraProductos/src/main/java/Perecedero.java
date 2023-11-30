public class Perecedero extends Producto{

    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precios) {
        super(nombre, precios);
        this.diasPorCaducar = diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public void calcular(double cantidadDeProductos){
        Producto producto = new Producto(getNombre(), getPrecios());
        switch (diasPorCaducar){
            case 1 ->{
                double precioFinal = (cantidadDeProductos * producto.getPrecios()) / 4;
                System.out.println("El producto tiene : " + diasPorCaducar + " antes de caducar, su precio original es de "
                        +getPrecios() + ", precio final con descuento: " + precioFinal);
            }case 2 ->{
                double precioFinal  = (cantidadDeProductos * producto.getPrecios()) / 3;
                System.out.println("El producto tiene : " + diasPorCaducar + " antes de caducar, su precio original es de "
                        +getPrecios() + ", precio final con descuento: " + precioFinal);
            }case 3 ->{
                double precioFinal  = (cantidadDeProductos * producto.getPrecios()) / 2;
                System.out.println("El producto tiene : " + diasPorCaducar + " antes de caducar, su precio original es de "
                        +getPrecios() + ", precio final con descuento: " + precioFinal);
            }
        }

    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }
}
