package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaSinParams = new Persona();
        Persona personaAlgunosParams = new Persona("Florencia", 27, "12345678");
        Persona personaTodosParams = new Persona("Juan", 12, "23456789", 78.5, 1.80);

        // ERROR: No se puede crear porque no contamos con un constructor que reciba esos parámetros
        // Persona personaErrorParams = new Persona("Pablo", 34);

        System.out.println(personaTodosParams);
    }
}