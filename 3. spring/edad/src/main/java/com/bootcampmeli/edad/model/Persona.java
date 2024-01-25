package com.bootcampmeli.edad.model;

public class Persona {
    private Integer edad;
    private String nombre;
    private String apellido;


    public Persona(Integer edad, String nombre, String apellido) {
        this.edad = edad;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Hola! Soy ");
        sb.append(nombre).append(' ').append(apellido);
        sb.append(" y tengo ").append(edad).append(" años.").append('\n');
        sb.append("Mi objeto persona es: ").append('\n');
        sb.append("Persona {").append('\n');
        sb.append("edad = ").append(edad).append(", ");
        sb.append("nombre = ").append(nombre).append(", ").append('\n');
        sb.append("apellido = ").append(apellido).append('\n');
        sb.append('}');
        return sb.toString();
    }
}
