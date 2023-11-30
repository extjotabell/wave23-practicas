package org.example;

import org.w3c.dom.ls.LSOutput;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args) {
        Persona personaJuan = new Persona();
        Persona personaCarolina = new Persona("Carolina", 25, "123456");
        Persona personaRodrigez = new Persona("Rodriguez", 32, "654321", 68, 1.75);
//    Persona personaRandom = new Persona("Random", 23); No es posible realizar esto por lo que no hay un constructor que tenga solo estos dos parametros


        int imc = personaRodrigez.calcularIMC();
        String edadPersona = personaRodrigez.esMayorDeEdad() ? " mayor de edad" : " menor de edad";
        System.out.println("La persona llamada " + personaRodrigez.nombre + edadPersona + ", de acuerdo a su IMC se considera lo siguiente: ");

        if(imc == -1){
            System.out.println("IMC -> Tiene bajo peso");
        } else if (imc == 0) {
            System.out.println("IMC -> Tiene peso saludable");
        } else {
            System.out.println("IMC -> Tiene sobrepeso");
        }
        System.out.println();
        System.out.println(personaRodrigez);
    }
}