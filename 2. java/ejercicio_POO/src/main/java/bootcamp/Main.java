package bootcamp;

public class Main {
    public static void main(String[] args) {

        Persona martin = new Persona();

        Persona hernan = new Persona("Hernan",22,"123456789");

        Persona zuly = new Persona("Zuly",23,"987654321",60.3,1.55);

        //No sería posible crear la 2 última instancia con dos parametros porque no tenemos un constructor para ello.

        int imc = zuly.calcularIMC();
        boolean mayor = zuly.esMayorDeEdad();


        System.out.println(zuly);
    }
}