package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Item implements Model {
    String id;
    String descripcion;
    private static Integer proximoId = 0;
    Double precio;

    public Item(String descripcion, Double precio) {
        this.descripcion = descripcion;
        this.precio = precio;
        this.id = String.valueOf(proximoId);

        proximoId++;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder('\n');
        sb.append("Descripcion: ").append(descripcion).append('\n');
        sb.append("Precio Unitario: $").append(precio).append('\n');
        return sb.toString();
    }

    @Override
    public String getId() {
        return this.id;
    }
}
