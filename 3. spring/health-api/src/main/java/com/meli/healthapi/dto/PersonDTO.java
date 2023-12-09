package com.meli.healthapi.dto;


import com.meli.healthapi.model.Symptom;

import java.util.List;

public class PersonDTO {
    private long id;
    private String name;
    private String lastName;
    private int age;
    private List<Symptom> symptoms;

    public PersonDTO(){}

    public PersonDTO(long id, String name, String lastName, int age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public PersonDTO(long id, String name, String lastName, int age, List<Symptom> symptoms) {
        this(id,name,lastName,age);
        this.symptoms = symptoms;
    }

    public String getName() {
        return name;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public long getId() {
        return id;
    }
    public List<Symptom> getSymptoms() {
        return symptoms;
    }

}
