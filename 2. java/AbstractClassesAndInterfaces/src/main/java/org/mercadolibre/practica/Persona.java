package org.mercadolibre.practica;

public abstract class Persona {

    int id;
    String name;
    int age;

    public Persona(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public abstract String speak();
}
