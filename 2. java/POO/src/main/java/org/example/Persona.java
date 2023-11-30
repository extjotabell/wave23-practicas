package org.example;

public class Persona {
    //Ejercicio 1
    String nombre;
    int edad;
    String dni;
    Double pesoEnKg;

    Double alturaEnM;

    //Ejercicio 2

    public Persona(){
        this.nombre = "";
        this.edad = 0;
        this.dni = "";
        this.pesoEnKg = 0.0;
        this.alturaEnM = 0.0;
    };

    public Persona(String nombre, Integer edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, Double pesoEnKg, Double alturaEnM) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.pesoEnKg = pesoEnKg;
        this.alturaEnM = alturaEnM;
    }

    //Ejercicio 5
    public Integer calcularIMC(){
        Double indice = (this.pesoEnKg/java.lang.Math.sqrt(this.alturaEnM));
        if(indice<20){
            return -1;
        }
        else if(indice >= 20 && indice <= 30){
            return 0;
        }
        else{
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return this.edad>=18;
    }

    public String toString(){
        String persona = "Nombre : " + this.nombre + " Edad : " + this.edad + " DNI : " + this.dni + " Peso : " + this.pesoEnKg +"Kg" + " Altura : " + this.alturaEnM + "M";
        return persona;
    }
}
