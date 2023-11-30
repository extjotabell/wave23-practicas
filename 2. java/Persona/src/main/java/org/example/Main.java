package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Diana", "123", 26);
        Persona persona3 = new Persona("Manuel", "123456", 25, 70.5, 1.75);

        int imc = persona3.calcularIMC();
        System.out.println(persona3);
        if(imc == 0){
            System.out.println("Esta bajo de peso");
        }else if (imc == 1){
            System.out.println("Tiene un peso saludable");
        }else{
            System.out.println("Tiene sobrepeso");
        }

        if (persona3.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }
    }

}