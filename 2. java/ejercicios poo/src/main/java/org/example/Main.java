package org.example;

import java.util.ArrayList;
import java.util.List;

// Ejercicio 3, 4 y 6
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Maria", 35, "123456");
        Persona persona3 = new Persona("Sofia", 19, "1234567", 70, 1.65);
        // Persona error = new Persona("Error", 404); No se puede crear este objeto ya que no tiene un constructor

        String mayorDeEdad = persona3.esMayorDeEdad() ? " es mayor de edad." : " es menor de edad.";
        System.out.println("El nivel de peso de " + persona3.getNombre() + " a raíz del IMC es: " + persona3.nivelDePeso() + ". " + persona3.getNombre() + mayorDeEdad);
        System.out.println(persona3);

        /*List<Persona> personas = new ArrayList<>();
        personas.addAll(List.of(persona1, persona2, persona3));
        for (Persona p : personas) {
            System.out.println(p.toString());
        }*/
    }
}