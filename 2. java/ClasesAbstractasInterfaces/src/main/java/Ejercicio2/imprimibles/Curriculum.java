package Ejercicio2.imprimibles;

import Ejercicio2.Imprimible;

import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {
    private String nombre;
    private List<String> habilidades;
    public Curriculum(String nombre, List<String> habilidades){
        this.nombre=nombre;
        this.habilidades=habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", habilidades=" + habilidades +
                '}';
    }
}