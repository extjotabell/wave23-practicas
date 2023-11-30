package org.example;

public class PracticaExcepciones {

    private static int a = 0;
    private static int b = 300;

    public static int cociente(){
        int resultado = 0;
        try{
            resultado = b/ a;
        }catch(ArithmeticException e){
            //System.out.println("Se ha producido un error");
            throw new IllegalArgumentException("No se puede dividir por 0");
        }finally {
            System.out.println("Programa finalizado");
        }

        return resultado;

    }

    public static void main(String[] args) {

        PracticaExcepciones.cociente();



    }
}
