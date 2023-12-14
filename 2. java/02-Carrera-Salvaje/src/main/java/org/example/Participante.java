package org.example;

public class Participante {
    private int id_participante;
    private String nombre;
    private int edad;
    public Participante(int id_participante, String nombre, int edad) {
        this.id_participante = id_participante;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getId_participante() {
        return id_participante;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}

