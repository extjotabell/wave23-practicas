package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public double calcularCociente(){
        try{
            return (this.b / this.a);
        } catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
            return -1;
        } finally {
            System.out.println("Programa finalizado");
        }
    }

    public double calcularCocienteBis(){
        try{
            return (this.b / this.a);
        } catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        } finally {
            System.out.println("Programa finalizado");
        }
    }
}
