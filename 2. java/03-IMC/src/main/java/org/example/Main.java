package org.example;

public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Jorge", 26, "MAMJ970909HDFRRR", 90, 1.74);
        Persona persona3 = new Persona("Rodrigo", 39, "MKHJKKDSNK", 70, 1.67);
        // Persona persona_prueba = new Persona("Rodrigo", 34); ----> No se puede construir.
        int resultado = persona3.calcularIMC();
        System.out.println(persona3.toString());
        switch (resultado){
            case -1 -> {
                System.out.println("Bajo Peso");
            }
            case 0 ->{
                System.out.println("Peso Saludable");
            }
            case 1 ->{
                System.out.println("Sobrepeso");
            }
            default -> {
                System.out.println("Sin resultados");
            }
        }
        Boolean edad = persona3.esMayorEdad();
        if(edad = true){
            System.out.println("Es mayor de Edad");
        }else {
            System.out.println("Es menor de edad");
        }

    }
}