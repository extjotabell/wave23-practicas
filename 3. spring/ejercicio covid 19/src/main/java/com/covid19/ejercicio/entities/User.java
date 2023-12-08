package com.covid19.ejercicio.entities;

public class User {
    private int id, age;
    private String name, surname;

    public User() {
    }

    public User(int id, int age, String name, String surname) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }
}
