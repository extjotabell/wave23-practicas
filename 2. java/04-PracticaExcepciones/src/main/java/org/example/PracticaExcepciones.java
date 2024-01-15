package org.example;

public class PracticaExcepciones {
    private int a = 0;
    private  int b = 300;

    public PracticaExcepciones(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int calcularCociente(){
        try {
            if(a ==0){
                throw  new IllegalArgumentException("No se puede dividir por 0");
            }else{
                return b / a;
            }
        }catch (ArithmeticException exeption){
            System.out.println("Se ha producido un error");
        }
        finally {
            System.out.println("Programa Finalizado");
        }
        return 0;
    }
}
