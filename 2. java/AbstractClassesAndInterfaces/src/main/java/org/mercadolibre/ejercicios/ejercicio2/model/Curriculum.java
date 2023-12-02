package org.mercadolibre.ejercicios.ejercicio2.model;

public class Curriculum extends Document {

    private Person person;

    public Curriculum(int id, Person person) {
        super(id);
        this.person = person;
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo curriculum");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
