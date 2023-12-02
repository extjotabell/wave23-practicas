package org.mercadolibre.exceptionsPractice.model;

public class ExceptionsPractice {
    private int a;
    private int b;

    public ExceptionsPractice(int a, int b) {
        this.a = a;
        this.b = b;

        quotientCalculator();
    }

    private void quotientCalculator(){
        double quotient = 0;
        try {
            quotient = b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }

    }
}
