package org.example;

import org.example.modelo.Persona;

public class Main {
    public static void main(String[] args) {
        Persona personaConstructorSinParametros = new Persona();

        Persona personaPrimerConstructor = new Persona("Sebas",23,"1010124016");

        Persona personaSegundoConstructor = new Persona("Mariana",22,"123456789",60.0,1.65);

        //Persona personaErronea = new Persona("Camilo",23);

        verificarEdad(personaSegundoConstructor);

        System.out.println(personaSegundoConstructor);

        //Se verifica con más valores
        personaSegundoConstructor.setEdad(17);
        personaSegundoConstructor.setPeso(90);

        verificarEdad(personaSegundoConstructor);

        System.out.println(personaSegundoConstructor);


    }

    public static void verificarEdad(Persona persona){
        if (persona.esMayorDeEdad()){
            System.out.println("La persona "+persona.getNombre()+" es mayor de edad.");
        }
        else {
            System.out.println("La persona "+persona.getNombre()+" es menor de edad.");
        }
    }

}