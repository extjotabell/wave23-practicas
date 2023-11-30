package org.example;

public class Main {
    public static void main(String[] args) {
        Persona camila = new Persona();
        Persona martin = new Persona("Martin", 27, 40200200);
        Persona maria = new Persona("Maria", 23, 40200201, 60, 1.75);

        //Persona juan = new Persona("Juan");
        //No se puede crear una Persona con solo el atributo nombre pues no existe ese constructor
        if(maria.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }
        else{
            System.out.println("La persona es menor de edad");
        }

        int imcMaria = maria.calcularIMC();
        if(imcMaria == -1){
            System.out.println("La persona tiene bajo peso");
        } else if(imcMaria == 0){
            System.out.println("La persona tiene peso saludable");
        } else{
            System.out.println("La persona tiene sobrepeso");
        }

        System.out.println(maria);


    }
}