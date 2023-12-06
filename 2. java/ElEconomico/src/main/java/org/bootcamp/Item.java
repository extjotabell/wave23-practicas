package org.bootcamp;

public class Item {

    protected Long codigo;
    protected int cantidad;
    protected String nombre;
    protected double precio_unitario;

    public Item(Long codigo, int cantidad, String nombre, double precio_unitario) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio_unitario = precio_unitario;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", cantidad=" + cantidad +
                ", nombre='" + nombre + '\'' +
                ", precio_unitario=" + precio_unitario +
                '}';
    }

}
