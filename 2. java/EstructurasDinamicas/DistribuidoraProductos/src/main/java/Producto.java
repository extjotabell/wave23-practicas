public class Producto {

    private String nombre;
    private double precios;

    public Producto(String nombre, double precios) {
        this.nombre = nombre;
        this.precios = precios;
    }

    public void calcular(double cantidadDeProductos){
        double multiplicar = cantidadDeProductos * precios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precios=" + precios +
                '}';
    }
}
