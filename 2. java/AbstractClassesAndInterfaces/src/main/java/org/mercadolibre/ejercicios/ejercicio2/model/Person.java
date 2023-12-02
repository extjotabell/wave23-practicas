package org.mercadolibre.ejercicios.ejercicio2.model;

import java.util.List;

public class Person {

    private String name;
    private String dni;
    private List<String> skills;

    public Person(String name, String dni, List<String> skills) {
        this.name = name;
        this.dni = dni;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }
}
