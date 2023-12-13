package com.spring.Covid19.DTOs;

import java.io.Serializable;

public class RiskPerson {
    private String name;
    private String lastname;

    public RiskPerson(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
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
}
