package org.example_1;

import java.util.List;

public class Autor extends Persona{
    public Autor(String nombre, int edad, List<String> habilidades) {
        super(nombre, edad, habilidades);
    }

    @Override
    public String toString() {
        return "Autor{}";
    }
}
