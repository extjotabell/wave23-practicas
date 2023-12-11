package com.bootcamp.edad.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class Persona {

    protected String nombre;
    protected Integer edad;
    protected LocalDate fechaNacimiento;

    public Persona(String nombre, LocalDate fechaNacimiento){
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.edad = this.obtenerEdad();
    }

    public Persona(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public int obtenerEdad(){
        LocalDate hoy = LocalDate.now();
        Period period = Period.between(this.fechaNacimiento, today);
        return period.getYears();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
