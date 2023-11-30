public class NoPerecedero extends Producto{
    private String tipo;

    public NoPerecedero(String tipo, String nombre, double precios) {
        super(nombre, precios);
        this.tipo = tipo;
    }

    public void calcular(double cantidadDeProductos){
        Producto producto = new Producto(getNombre(), getPrecios());
        double multiplicar = cantidadDeProductos * producto.getPrecios();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
