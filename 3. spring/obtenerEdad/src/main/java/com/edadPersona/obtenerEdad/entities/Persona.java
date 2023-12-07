package com.edadPersona.obtenerEdad.entities;

public class Persona {
    private String nombre;
    private String apellido;
    private String fechaNac;
    private int edad;

    public Persona(String nombre, String apellido, String fechaNac) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
