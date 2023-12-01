package org.example;

import java.util.List;

public class Curriculum extends Documento {
    private String nombre;
    private String apellido;
    private String dni;
    private int edad;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String dni, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", habilidades=" + habilidades +
                '}');
    }
}
