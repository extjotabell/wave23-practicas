package com.company;

public class PracticaExecepciones {

    private int a;
    private int b;


    public void calcularCociente(int a, int b) {
        try {
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por cero");
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Programa finalizado");
        }

    }
}
