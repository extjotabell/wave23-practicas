package org.example;

public class Main {
    public static void main(String[] args) {
        //Ejercicio 1
        Integer cociente;
        try{
            PracticaExcepciones practica = new PracticaExcepciones();
            cociente = (practica.b/ practica.a);
        }
        catch(Exception e){
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por cero");
        }
        finally {
            System.out.println("Programa finalizado");
        }

        //Ejercicio 2

    }
}