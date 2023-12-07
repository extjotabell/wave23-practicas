package com.example.ejercicio_edad.entities;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Persona {
    private static String nombre = "Martin";
    private static String apellido = "Lackington";
    private LocalDate fechaNacimiento;

    private Long edad;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getEdad() {
        return edad;
    }

    public void setEdad(Long edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Hola soy " + nombre + " mi apellido es " + apellido + " y tengo " + edad + " años";
    }
}
