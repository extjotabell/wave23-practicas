package org.example;

public class PracticaExcepciones {

    private int a = 0;
    private int b = 300;

    public void calcularCociente(){
        try{
            int resultado = this.b/this.a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa Finalizado.");
        }
    }
}
