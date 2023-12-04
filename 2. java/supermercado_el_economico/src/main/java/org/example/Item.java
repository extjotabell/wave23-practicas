package org.example;

public class Item {
    private String lcodigo, nombr;
    private int cantidad;
    private double costoUnitario;

    public String getLcodigo() {
        return lcodigo;
    }

    public void setLcodigo(String lcodigo) {
        this.lcodigo = lcodigo;
    }

    public String getNombr() {
        return nombr;
    }

    public void setNombr(String nombr) {
        this.nombr = nombr;
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

    public Item(String lcodigo, String nombr, int cantidad, double costoUnitario) {
        this.lcodigo = lcodigo;
        this.nombr = nombr;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }
}
