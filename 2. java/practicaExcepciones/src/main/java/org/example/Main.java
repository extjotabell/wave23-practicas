package org.example;

public class Main {
    public static void main(String[] args) {
        int a = 0;
        int b = 300;
        // Ejercicio 1.1
        try{
            int cociente1 = b/a;
        } catch (ArithmeticException exec){
            System.out.println("Se ha producido un error");
        } finally {
            System.out.println("Programa finalizado");
        }

        //Ejercicio 1.2
        int c = 0;
        int d = 300;
        try{
            int cociente2 = d/c;
        } catch (ArithmeticException exec){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }




    }
}