package org.example_1;

public class Curriculums implements Imprimible {

    public Curriculums(Persona persona) {
        this.persona = persona;
    }

    private Persona persona;

    @Override
    public String imprimiendo(){
        return persona.toString();
    }
}
