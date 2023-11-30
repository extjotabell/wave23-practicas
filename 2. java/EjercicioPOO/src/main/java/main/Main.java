package main;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Marcos", 25, "40955907");
        Persona p3 = new Persona("Marcos", 25, "40955907", 65, 1.72);

        // Esto no es posible hacer ya que no tenemos definido en Persona un constructor que solamente reciba nombre y edad
        //Persona p4 = new Persona("Marcos", 25);

        int imc = p3.calcularIMC();
        System.out.printf("\nIMC de la persona: ");
        if (imc == -1) {
            System.out.println("Bajo peso\n");
        }
        else if (imc == 0) {
            System.out.println("Peso saludable\n");
        }
        else {
            System.out.println("Sobrepeso\n");
        }

        if (p3.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad\n");
        }
        else {
            System.out.println("La persona es menor de edad\n");
        }

        System.out.println(p3);
    }
}