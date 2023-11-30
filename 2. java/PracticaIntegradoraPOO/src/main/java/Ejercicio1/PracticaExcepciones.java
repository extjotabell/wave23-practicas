package Ejercicio1;

public class PracticaExcepciones {
    static int a = 0;
    static int b = 300;

    public static void main(String[] args) {

        //1.
        try {
            int division = b / a;
        } catch (ArithmeticException e) {
            System.out.println("Se ha producido un error");
        }

        //2.
/*        try {
            int division = b/a;
        }catch (ArithmeticException e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }*/

        System.out.println("Programa finalizado");
    }
}
