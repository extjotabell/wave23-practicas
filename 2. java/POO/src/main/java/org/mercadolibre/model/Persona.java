package org.mercadolibre.model;

public class Persona {
    private String name;
    private String dni;
    private double weight;
    private double height;
    private int age;

    public Persona() {
    }

    public Persona(String name, String dni, int age) {
        this.name = name;
        this.dni = dni;
        this.age = age;
    }

    public Persona(String name, String dni, double weight, double height, int age) {
        this.name = name;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public int calcularIMC() {
        double imc = weight / (Math.pow(height, 2));
        return (imc < 20) ? -1 : (imc <= 25) ? 0 : 1;

    }

    public boolean mayorDeEdad() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Nombre=" + name + "\n" +
                "DNI=" + dni + "\n" +
                "Peso=" + weight + "\n" +
                "Altura=" + height + "\n" +
                "Edad=" + age +  "\n";
    }
}
