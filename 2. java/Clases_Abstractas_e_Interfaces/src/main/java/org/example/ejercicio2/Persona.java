package org.example.ejercicio2;

public class Persona {
    String nombre;
    int edad;
    String dni;

    public Persona(String nombre, Integer edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Persona: ");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", edad=").append(edad);
        sb.append(", dni='").append(dni).append('\'');
        return sb.toString();
    }
}
