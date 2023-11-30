public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Felipe", 20, "44967716");
        Persona p3 = new Persona("Felipe", 20, "44967716", 60, 1.7);

        /*
         *Persona p4 = new Persona("Felipe", 20);
         * Lanzaria un error de compilacion ya que no existe
         * un constructor que reciba estos parametros
         * */

        System.out.println(p3);
        String nivelDePeso = "";
        switch (p3.calcularIMC()){
            case -1->{nivelDePeso="bajo";}
            case 0->{nivelDePeso="saludable";}
            case 1->{nivelDePeso="sobrepeso";}
        }
        System.out.println("El nivel de peso de " + p3.name  + " es " + nivelDePeso);
    }
}
