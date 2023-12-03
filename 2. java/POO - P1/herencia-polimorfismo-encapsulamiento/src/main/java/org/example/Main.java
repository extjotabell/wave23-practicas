package org.example;


public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Camila Paez","12345678",35);
        Persona persona3 = new Persona("Mariano Martínez","82735195",18,60,1.7);

        //Persona personaConError = new Persona("Fake Persona",67); Esto no se puede hacer porque no hay constructor definido para estos tipos de parámetros

        String mayorDeEdad = persona3.esMayorDeEdad() ? " Es MAYOR de edad." : " Es MENOR de edad.";
        System.out.printf("Resultado IMC: %s   %s\n\n", persona3.nivelPeso(), mayorDeEdad);
        System.out.println(persona3);
    }
}