package com.covid19.ejercicio.entities;

public class Symptom {
    private int code;
    private String name, severityLevel;

    public Symptom() {
    }

    public Symptom(int code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getName() {
        return name;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    @Override
    public String toString() {
        return "Symptom{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", severityLevel='" + severityLevel + '\'' +
                '}';
    }
}
