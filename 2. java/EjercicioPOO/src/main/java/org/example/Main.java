package org.example;

public class Main {

    public static void main(String[] args) {
        Persona juan = new Persona();
        Persona maria = new Persona("Maria", 25, "12345689");
        Persona lucas = new Persona("Lucas", "34748573", 29, 75.0, 1.8);

        // Constructor a modo de error
        // Persona pablo = new Persona("Pablo", 30); --> No se puede ya que no existe constructor

        // Datos de la persona
        String datos = lucas.toString();
        System.out.println(datos);

        // Validacion de Edad
        if (lucas.esMayorDeEdad()) {
            System.out.println("La persona es mayor de edad.");
        }
        else {
            System.out.println("La persona es menor de edad.");
        }

        //Calculo de IMC
        int imc = lucas.calcularIMC();
        switch (imc){
            case -1:
                System.out.println("Bajo Peso");
                break;
            case 0:
                System.out.println("Peso Saludable");
                break;
            case 1:
                System.out.println("Sobrepeso");
                break;
            case 999:
                System.out.println("No se puede calcular IMC debido a que falta dato sobre peso y/o altura.");
                break;
        }
    }

}