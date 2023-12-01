public class PracticaExcepciones {
    private static int a = 0;
    private static int b = 300;

    public static void main(String[] args) {
        try{
            int cociente = b/a;
        }catch(ArithmeticException e){
            //System.out.println("Error.");
            throw new IllegalArgumentException("You can't divide with zero");
        }finally{
            System.out.println("Progranm finished.");
        }
    }
}
