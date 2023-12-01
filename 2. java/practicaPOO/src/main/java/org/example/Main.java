package org.example;

public class Main {
    public static void main(String[] args) {
        Persona greta       = new Persona();
        Persona claudia     = new Persona("Claudia",20,"165489001");
        Persona vicky       = new Persona("Vicky", 16, "18354099", 55, 1.68);

        double resultadoIMC = vicky.calcularIMC();
        String mensajeIMC = "";
        if (resultadoIMC == 0 ) {
            mensajeIMC = "Peso saludable";
        } else if (resultadoIMC == -1) {
            mensajeIMC = "Bajo peso";
        } else if (resultadoIMC == 1){
            mensajeIMC = "Sobrepeso";
        }

        String mensajeMayorEdad = "";
        if (vicky.esMayorDeEdad()) {
            mensajeMayorEdad = "mayor de edad";
        } else {
            mensajeMayorEdad = "menor de edad";
        }

        System.out.println("El resultado IMC de Vicky es: " + mensajeIMC + " y es: " + mensajeMayorEdad);
        System.out.println(vicky);
    }

}