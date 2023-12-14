package com.edadpersona.ejercicio.entities;

public class Person {
    private String name, surname, dob;

    public Person() {
    }

    public Person(String name, String surname, String dob) {
        this.name = name;
        this.surname = surname;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDob() {
        return dob;
    }
}
