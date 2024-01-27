package org.example.ejercicio2;

import java.util.ArrayList;

public class Curriculum implements Imprimible{
    private Persona persona;
    private ArrayList<String> habilidades;

    public Curriculum(Persona persona, ArrayList<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimirDocumento() {
        System.out.println("CV");
        System.out.println(this.persona.toString());
        System.out.println("Habilidades: " + this.habilidades);
        System.out.println();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Curriculum{");
        sb.append("persona=").append(persona);
        sb.append(", habilidades=").append(habilidades);
        sb.append('}');
        return sb.toString();
    }
}
