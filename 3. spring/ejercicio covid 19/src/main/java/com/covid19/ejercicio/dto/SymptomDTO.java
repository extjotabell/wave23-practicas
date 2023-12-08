package com.covid19.ejercicio.dto;

public class SymptomDTO {
    private String name, severityLevel;

    public SymptomDTO() {
    }

    public SymptomDTO(String name, String severityLevel) {
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getName() {
        return name;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSeverityLevel(String severityLevel) {
        this.severityLevel = severityLevel;
    }
}
