import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Byte numero1 = 4;
        Integer numero2 = 4;
        Double numero3 = 3.00d;
        Float numero4 = 10.0f;

        ClaseUno claseUno = new ClaseUno(numero1, numero2);

        System.out.println("Serie de 2:");
        Stream.generate(claseUno::siguiente)
                .limit(5)
                .forEach(valor -> System.out.println("Valor siguiente: " + valor));

        claseUno.establecerInicial(1);
        System.out.println("\nSerie con valor inicial 1:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor siguiente: " + claseUno.siguiente());
        }

        ClaseDos claseDos = new ClaseDos(numero3, numero4);
        System.out.println("\nSerie de multiplicación por 3:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Valor siguiente: " + claseDos.siguiente());
        }
    }
}
