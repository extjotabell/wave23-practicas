package com.spring.Covid19.entities;

import java.util.List;
import java.util.Random;

public class Person {

    private Integer id;
    private String name;
    private String lastname;
    private  Integer edad;
    private List<Symptom> symptoms;

    public Person(String name, String lastname, Integer edad) {
        this.id = new Random().nextInt(1000);
        this.name = name;
        this.lastname = lastname;
        this.edad = edad;
        this.symptoms = null;
    }

    public Person(String name, String lastname, Integer edad, List<Symptom> symptoms) {
        this.id = new Random().nextInt(1000);
        this.name = name;
        this.lastname = lastname;
        this.edad = edad;
        this.symptoms = symptoms;
    }

    public boolean isRiskPerson(){
        return this.edad > 60  ? true : false;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
