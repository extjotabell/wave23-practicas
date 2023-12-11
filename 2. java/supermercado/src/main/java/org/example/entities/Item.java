package org.example.entities;

public class Item {
    private Long id;
    private String nombre;
    private Integer cantidad;
    private Double costoUnitario;

    public Item() {
    }

    public Item(Long id, String nombre, Integer cantidad, Double costoUnitario) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public Long getCodigo() {
        return id;
    }

    public void setCodigo(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(Double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return  "\n" + nombre + " (" + cantidad + " x $" + costoUnitario + ")";
    }
}
