package org.ejercicio_2;

public class Curriculums implements Imprimible {

    public Curriculums(Persona persona) {
        this.persona = persona;
    }

    private Persona persona;

    @Override
    public String imprimir(){
        return "Curriculum: " +  persona.toString();
    }
}
