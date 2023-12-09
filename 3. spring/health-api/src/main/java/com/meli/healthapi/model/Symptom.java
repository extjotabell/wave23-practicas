package com.meli.healthapi.model;

import com.meli.healthapi.enums.SEVERITY;

public class Symptom {
    long code;
    String name;
    SEVERITY severity;

    public Symptom(long code, String name, SEVERITY severity) {
        this.code = code;
        this.name = name;
        this.severity = severity;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SEVERITY getSeverity() {
        return severity;
    }

    public void setSeverity(SEVERITY severity) {
        this.severity = severity;
    }
}
