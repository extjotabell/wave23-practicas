package org.example;

public class PracticaExccepciones {
    private int a;
    private int b;

    public PracticaExccepciones() {
    }

    public PracticaExccepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int calcularCociente(){
        int resultado = 0;
        try {
            if(this.a == 0){
               throw new IllegalArgumentException("No se puede dividir por cero");
            }else{
              resultado = this.b/this.a;}
        } catch (ArithmeticException e) {
            System.out.printf("Error: " + e.getMessage());
        }
        catch (IllegalArgumentException e){
            System.out.printf("Error: " + e.getMessage());
        }
        return resultado;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
