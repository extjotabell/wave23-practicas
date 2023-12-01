package org.mercadolibre;

import org.mercadolibre.model.Persona;

public class Main {
    public static void main(String[] args) {
        Persona personEmpty = new Persona();
        Persona personThreeAtributes = new Persona("Arami","11234534", 25);
        Persona personFullAtributes = new Persona("Alice","41795112", 100,1.69, 15);

        System.out.print("Datos Personales: \n" + personFullAtributes);
        String nivelPeso = "Fuera de rango";
        switch (personFullAtributes.calcularIMC()){
            case -1->{nivelPeso ="Bajo peso";}
            case 0->{nivelPeso="Peso normal";}
            case 1->{nivelPeso="Sobrepeso";}
        }

        System.out.print("Su peso entá dentro del rango: " + nivelPeso + "\n");
        if(personFullAtributes.mayorDeEdad()){
            System.out.println("Es mayor de edad.");
        }else {
            System.out.println("Es menor de edad.");
        }

    }
}