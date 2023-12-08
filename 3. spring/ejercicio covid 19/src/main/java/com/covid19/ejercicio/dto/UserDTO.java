package com.covid19.ejercicio.dto;

import com.covid19.ejercicio.entities.Symptom;

import java.util.ArrayList;

public class UserDTO {
    private String fullName;
    private int age;
    private ArrayList<Symptom> symptoms;

    public UserDTO() {
    }

    public UserDTO(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSymptoms(ArrayList<Symptom> symptoms) {
        this.symptoms = symptoms;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", symptoms=" + symptoms +
                '}';
    }
}
