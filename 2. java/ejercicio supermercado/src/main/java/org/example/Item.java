package org.example;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private int costoUnitario;

    public Item(String codigo, String nombre, int cantidadComprada, int costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public int getCostoUnitario() {
        return costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", cantidadComprada=" + cantidadComprada +
                ", costoUnitario=" + costoUnitario +
                '}';
    }
}
