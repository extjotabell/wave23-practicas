package org.example.modelo;

import java.util.List;

public class Curriculum implements Imprimible{
    private String nombre;
    private int edad;
    private String direccion;
    private List<String> habilidades;

    public Curriculum(String nombre, int edad, String direccion, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Dirección: " + direccion);
        System.out.println("Habilidades:");
        habilidades.forEach(habilidad -> System.out.println("- " + habilidad));
        System.out.println();
    }
}
