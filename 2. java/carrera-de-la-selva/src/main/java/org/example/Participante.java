package org.example;

public class Participante {

    private int id;
    private int edad;
    private String nombre;
    private String apellido;
    private String dni;

    public Participante(int id, int edad, String nombre, String apellido, String dni) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getEdad(){
        return this.edad;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }
}
