package org.mercadolibre;

import org.mercadolibre.model.Person;

public class Main {
    public static void main(String[] args) {
        Person personEmpty = new Person();
        Person personThreeAtributes = new Person("Arami","11234534", 25);
        Person personFullAtributes = new Person("Alice","41795112", 100,1.69, 15);

        System.out.print("********** Datos Personales **********\n" + personFullAtributes);
        String weightLevel = "Fuera de rango";
        switch (personFullAtributes.calculateBMI()){
            case -1->{weightLevel ="Bajo peso";}
            case 0->{weightLevel="Peso normal";}
            case 1->{weightLevel="Sobrepeso";}
        }

        System.out.println("Su peso entá dentro del rango: " + weightLevel);
        if(personFullAtributes.isAdult()){
            System.out.println("Es mayor de edad.");
        }else {
            System.out.println("Es menor de edad.");
        }

    }
}