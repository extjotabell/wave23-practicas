package org.example.Modelo;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double costoUnitario;

    public Item(String codigo, String nombre, int cantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getcostoUnitario() {
        return costoUnitario;
    }

    public void setcostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "\n" +
                "Codigo: " + codigo + '\n' +
                "Nombre: '" + nombre + '\n' +
                "Cantidad: " + cantidad + '\n' +
                "CostoUnitario: " + costoUnitario +
                '\n';
    }
}
