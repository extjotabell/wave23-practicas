package org.example;

public class Main {
    public static void main(String[] args) {
        Persona tomas = new Persona();
        Persona andres = new Persona("Andres", 30, "23456789");
        Persona lucas = new Persona("Lucas", 29, "98765432", 75.0, 1.80);

        try {

            System.out.println("El resultado de IMC es: " + lucas.calcularIMC());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Es mayor de edad? " + lucas.esMayorDeEdad());
        System.out.println(lucas.toString());

    }
}