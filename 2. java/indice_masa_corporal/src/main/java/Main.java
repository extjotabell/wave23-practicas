public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Juan", 20, "12345678A");
        Persona p3 = new Persona("Pedro", 30, "87654321B", 80, 1.80);

        // Calcular IMC persona 3 e imprimir mensaje acorde
        int imc = p3.cacularIMC();

        switch (imc) {
            case -1 -> System.out.println("Bajo peso");
            case 0 -> System.out.println("Peso saludable");
            case 1 -> System.out.println("Sobrepeso");
        }

        // ¿Es mayor de edad?
        System.out.println(p3.esMayorDeEdad() ? "Es mayor de edad" : "Es menor de edad");

        // Imprimir persona 3
        System.out.println(p3);
    }
}
