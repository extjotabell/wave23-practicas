package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Curriculum extends Documento {
    String nombre;
    String edad;
    String sexo;
    ArrayList<String> habilidades = new ArrayList<>();

    public Curriculum(String nombre, String edad, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }

    public ArrayList agregarHabilidades(){
        habilidades.add("Python");
        habilidades.add(("Java"));
        habilidades.add("Patrones de Diseño");
        return  habilidades;
    }


    @Override
    public void imprimir() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Sexo: " + sexo);
        System.out.println("Habilidades: ");

        for(String habilidad : habilidades){
            System.out.println(habilidad);
        }

    }

    @Override
    public void imprimirTipoDocumento() {

    }
}
