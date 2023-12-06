package org.example.Ej2;

import java.util.ArrayList;

public class Curriculum extends Documento{

    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
    }

    public void agregarHabilidad(String habilidad) { habilidades.add(habilidad);}

    @Override
    public String toString() {
        return "Curriculums";
    }

    @Override
    public void imprimir() {

    }

}
