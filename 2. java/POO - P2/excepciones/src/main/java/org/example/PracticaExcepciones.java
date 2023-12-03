package org.example;

public class PracticaExcepciones {


    private final int a= 0 ;
    private final int b = 300;


    /*
     *1- Crear una clase PracticaExcepciones que defina los atributos a = 0 y b = 300 de tipo int.
     *  Calcular el cociente de b/a. Controlar la excepción que se lanza indicando el mensaje
     * “Se ha producido un error”. Al final del programa siempre deberá indicar el
     * mensaje “Programa finalizado”

     * */
    public void calculoCociente1(){

        try {
            int cociente = b / a;
            System.out.println("Cociente: " + cociente);
        } catch (Exception e) {
            System.out.println("No se puede dividir por cero: " + e.getMessage());
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    /*
    *   2-Modificar el programa anterior para que, al producirse el error, en vez de imprimir
     *  por consola el mensaje “Se ha producido un error”, lo lance como una excepción de tipo
     * IllegalArgumentException con el mensaje “No se puede dividir por cero”

     * */
    public void calculoCociente2(){

        try {
            if (a == 0) {
                throw new IllegalArgumentException("No se puede dividir por cero");
            }

            int cociente = b / a;
            System.out.println("Cociente: " + cociente);
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();;
        }
    }


}
