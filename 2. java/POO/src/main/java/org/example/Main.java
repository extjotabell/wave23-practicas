package org.example;

import java.sql.SQLOutput;

public class Main {
    //Ejercicio 3
    public static void main(String[] args) {
        //Ejercicio 4

        Persona primeraPersona = new Persona();
        Persona segundaPersona = new Persona("Jose Perez", 24, "24654789");
        Persona terceraPersona = new Persona("Luis Tellez", 58, "14794799", 89.0, 1.52);

        // Persona personaErronea = new Persona("Errorio Ruiz", 99);
        // Si trato de crear a esta persona voy a tener un error de compilación porque el constructor no existe

        //Ejercicio 6

        System.out.println("Persona: " + terceraPersona.nombre);
        System.out.println("Es mayor de edad?: " + terceraPersona.esMayorDeEdad());
        String nivelDePeso = "";
        switch(terceraPersona.calcularIMC()){
            case -1:{
                nivelDePeso = "Bajo peso";
            };
            case 0:{
                nivelDePeso = "Peso saludable";
            };
            case 1:{
                nivelDePeso = "Sobrepeso";
            };
        }
        System.out.println("Nivel de peso: " + nivelDePeso);
    }
}