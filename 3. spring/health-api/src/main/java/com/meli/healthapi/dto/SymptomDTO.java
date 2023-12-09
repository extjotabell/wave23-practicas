package com.meli.healthapi.dto;


import com.meli.healthapi.enums.SEVERITY;

public class SymptomDTO {
    private long code;
    private String name;
    private SEVERITY severity;

    public SymptomDTO(long code, String name, SEVERITY severity) {
        this.code = code;
        this.name = name;
        this.severity = severity;
    }

    public long getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public SEVERITY getSeverity() {
        return severity;
    }

}
