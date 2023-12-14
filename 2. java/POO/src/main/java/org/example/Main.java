package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
       Persona persona1 = new Persona();
       Persona persona2= new Persona("Rodrigo", 26, "MAMJ970909HDFRRR09");
       Persona persona3 = new Persona("Wendy", 12, "EWLKAKEDL8979", 56, 1.50);
       //Persona persona_prueba = new Persona("Josue", 14);
        System.out.println("El paciente: " + persona3.getNombre() + " con " + persona3.getEdad() + " Anios de Edad " + " Peso de: " + persona3.getPeso() + "Kg. Y altura de: " +persona3.getAltura() + "mtrs");
        System.out.println("Tiene un IMC de: " + persona3.calcularIMC(persona3));
        System.out.println("¿Es mayor de edad?: " + persona3.esMayorEdad(persona3));
        
    }
}