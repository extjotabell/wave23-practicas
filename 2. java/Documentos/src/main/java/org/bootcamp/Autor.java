package org.bootcamp;

import java.util.List;

public class Autor extends Persona{

    protected String iniciales;

    public Autor(String nombre, String apellido, int edad, String iniciales) {
        super(nombre, apellido, edad);
        this.iniciales = iniciales;
    }

    public String getIniciales() {
        return iniciales;
    }

    public void setIniciales(String iniciales) {
        this.iniciales = iniciales;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "iniciales='" + iniciales + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                '}';
    }
}
