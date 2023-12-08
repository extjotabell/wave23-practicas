package com.calculadora.edades.entities;

import java.util.Date;

public class Persona {
    private Date nacimiento;
    private String nombre;
    private String id;

    public Persona(Date nacimiento, String nombre,String id) {
        this.nacimiento =nacimiento;
        this.nombre = nombre;
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nacimiento=" + nacimiento +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
