package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List lista1 = new ArrayList();
        //Instanciar personas:

        Persona persConstructorSinParametros = new Persona();
        Persona persConstructor2 = new Persona("Ailen", 28, "38855748");
        Persona persConstructorCompleto = new Persona("Ailen", 28, "38855748", 70, 1.70);

        //A continuación vamos a crear otro objeto de tipo persona y vamos a construirlo pasando solamente un valor para el nombre y otro para la edad en el constructor. ¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?
        //No es posible ya que no existe un constructor con esas características
        //Candidates for new Persona() are:   Persona()   Persona(String nombre, int edad, String dni)   Persona(String nombre, int edad, String dni, double peso, double altura)

        //Ejercicio 6

        mostrarResultados(persConstructorCompleto.cacularIMC());
        verEdad(persConstructorCompleto.esMayorDeEdad());
    }
    public static void verEdad(boolean edad){
        if(edad){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }
    }
    public static void mostrarResultados(int IMC){
        switch (IMC){
            case -1 -> {
                System.out.println("Segun el Índice de masa corporal (IMC) tu nivel de peso es bajo");
            }
            case 0 ->{
                System.out.println("Segun el Índice de masa corporal (IMC) tu nivel de peso es saludable");
            }
            case 1 ->{
                System.out.println("Segun el Índice de masa corporal (IMC) tu nivel de peso es alto");
            }
        }
    }
}