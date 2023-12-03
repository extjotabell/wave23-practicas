package Ejercicio2;

import java.util.List;

public class Persona {
    private String nombre;
    private List<String> habilidades;

    public Persona(String nombre, List<String> habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }
}
