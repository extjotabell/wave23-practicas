package models;

public class Producto {
    private double costo;
    private String nombre;
    private String codigo;

    public Producto(double costo, String nombre, String codigo) {
        this.costo = costo;
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
