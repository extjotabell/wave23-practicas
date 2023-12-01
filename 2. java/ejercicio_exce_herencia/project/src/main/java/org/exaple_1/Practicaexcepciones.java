package org.exaple_1;

public class Practicaexcepciones {
    private int a;
    private int b;

    public Practicaexcepciones(int a, int b) {
        this.a = a;
        this.b = b;
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

    public static int  dividir(int numerador, int denominador) {
        if (denominador == 0) {
            // Lanzar una IllegalArgumentException personalizada
            throw new IllegalArgumentException("No puedes dividir por cero");
        }
        return numerador / denominador;
    }

    public static void main(String[] args) {

        Practicaexcepciones suma = new Practicaexcepciones(0,300);

        try {
            System.out.println(dividir(suma.getB(), suma.getA()));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Programa Finalizado");
        }
    }
}
