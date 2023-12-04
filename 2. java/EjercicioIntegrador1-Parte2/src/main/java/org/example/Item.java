package org.example;

public class Item {

    private int codigo;
    private String nombre;
    private int cant;
    private double costoUnitario;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public Item(int codigo, String nombre, int cant, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cant = cant;
        this.costoUnitario = costoUnitario;
    }

}
