package org.ejercicio.ejerciciodos.modelo.impl;

import org.ejercicio.ejerciciodos.modelo.Persona;

import java.util.List;

public class Curriculum extends Documento{

    Persona persona;
    List<String> habilidades;

    public Curriculum(String id, Persona persona, List<String> habilidades) {
        super(id);
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }
}
