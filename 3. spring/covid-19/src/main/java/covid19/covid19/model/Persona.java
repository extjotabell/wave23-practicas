package covid19.covid19.model;

import java.util.ArrayList;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;

    private ArrayList<Sintoma> sintomas;

    public Persona(int id, String nombre, String apellido, int edad, ArrayList<Sintoma> sintomas) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.sintomas = sintomas;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getApellido(){
        return this.apellido;
    }

    public int getEdad(){
        return this.edad;
    }

    public ArrayList<Sintoma> getSintomas(){
        return this.sintomas;
    }
}
