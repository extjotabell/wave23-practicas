package org.example;

public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona();
        Persona p2 = new Persona("Miguel", 22, "123");
        Persona p3 = new Persona("Miguel", 22, "123", 67, 177);

        System.out.println(p3);
        System.out.println((p3.calcularIMC() == -1) ?
                "La persona tiene bajo peso" : ((p3.calcularIMC() == 0) ?
                        "La persona tiene peso saludable" : "La persona tiene sobre peso"));
        System.out.println(p3.esMayorDeEdad() ? "La persona es mayor de edad" : "La persona es menor de edad");
    }
}