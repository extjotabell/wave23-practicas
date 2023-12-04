package org.example;

public class Cliente {
    private static int nextId;
    private final int id;
    private String nombre;
    private String apellido;
    private String dni;

    public Cliente(String nombre, String apellido, String dni) {
        this.id = ++ nextId;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                '}';
    }
}
