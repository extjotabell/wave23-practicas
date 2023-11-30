package org.example;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void cociente(){
        double res;
        try{
            res = b/a;
        }catch (Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Promgrama finalizado");
        }

    }
}