package org.ejercicios.ejercicioUno.modelo;

public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public void division(){

        try{
            int resultado = b/a;

        }catch(Exception e){
            //System.out.println("SE HA PRODUCIDO UN ERROR. ");
            throw new IllegalArgumentException("ERROR: SE ESTA DIVIDIENDO POR CERO!");

        }finally{
            System.out.println("PROGRAMA FINALIZADO.");
        }

    }
}
