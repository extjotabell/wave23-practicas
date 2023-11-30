public class Producto {

    protected String nombre;
    protected double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return String.format("Nombre: %s, Precio: %f", this.nombre, this.precio);
    }

    public double calcular(int cantidad){
        System.out.println(this.precio * cantidad);
        return this.precio * cantidad;
    }

}
