package org.bootcamp;

import java.util.List;
import java.util.ArrayList;

public class Cliente {

    protected static int idCount = 0;
    protected static List<Cliente> clientes = new ArrayList<>();

    protected final int id;

    protected String nombre;

    public Cliente(String nombre){
        ++idCount;
        this.id = idCount;
        this.nombre = nombre;

        clientes.add(this);
    }

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}