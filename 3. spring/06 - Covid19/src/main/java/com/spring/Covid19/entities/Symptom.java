package com.spring.Covid19.entities;

import java.util.Random;

public class Symptom {
    private Integer code;
    private String name;
    private Integer severityLevel;

    public Symptom(String name, Integer severityLevel) {
        this.code = new Random().nextInt(1000);
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSeverityLevel() {
        return severityLevel;
    }

    public void setSeverityLevel(Integer severityLevel) {
        this.severityLevel = severityLevel;
    }
}
