package org.example;

public class Main {
    public static void main(String[] args) {

        Persona personaConstructorSinParametros = new Persona();

        Persona personaPrimerConstructor = new Persona("Nico",22,"232132323");

        Persona personaSegundoConstructor = new Persona("Mar",42,"3423424344",50.0,1.60);


        //No se puede ya que no hay un constructor con estos parametros
        //Persona personaError = new Persona("Lolo",22);

        int imc = personaSegundoConstructor.calcularIMC();
        if( imc == -1){
            System.out.println("Tiene un Bajo Peso");
        }else if(imc == 0){
            System.out.println("Tiene un Peso Saludable");
        }else{
            System.out.println("Tiene Sobrepeso");
        }


        if(personaSegundoConstructor.esMayorDeEdad()){
            System.out.println("Es mayor de edad");
        }else{
            System.out.println("Es menor de edad");
        }

        System.out.println(personaSegundoConstructor.toString());
    }

}