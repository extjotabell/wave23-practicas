package org.example;

public class Item {
    private String codigo, nombre;
    private int cantidad;
    private double costoUnitario;

    public String getLcodigo() {
        return codigo;
    }

    public void setLcodigo(String lcodigo) {
        this.codigo = lcodigo;
    }

    public String getNombr() {
        return nombre;
    }

    public void setNombr(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public double getCosto(){
        return this.costoUnitario * this.cantidad;
    }

    public Item(String codigo, String nombre, int cantidad, double costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }
}
