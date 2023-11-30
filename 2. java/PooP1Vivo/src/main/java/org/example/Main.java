package org.example;

import org.example.modelo.Persona;

public class Main {
    public static void main(String[] args) {
        Persona personaConstructorSinParametros = new Persona();

        Persona personaPrimerConstructor = new Persona("Sebas",23,"1010124016");

        Persona personaSegundoConstructor = new Persona("Mariana",22,"123456789",70.0,165.0);
        
        //Persona personaErronea = new Persona("Camilo",23);
    }
}