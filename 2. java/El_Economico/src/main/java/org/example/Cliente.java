package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cliente extends CRUD <Cliente> implements Model {
    private String dni;
    private String id;
    private static Integer proximoId = 0;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = proximoId.toString();

        proximoId++;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\n");
        sb.append("DNI: ").append(dni).append('\n');
        sb.append("Nombre: ").append(nombre).append('\n');
        sb.append("Apellido: ").append(apellido).append('\n');
        return sb.toString();
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public String getId() {
        return dni;
    }
}
