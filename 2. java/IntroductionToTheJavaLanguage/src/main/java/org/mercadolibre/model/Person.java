package org.mercadolibre.model;

public class Person {
    private String name;
    private String dni;
    private double weight;
    private double height;
    private int age;

    public Person() {
    }

    public Person(String name, String dni, int age) {
        this.name = name;
        this.dni = dni;
        this.age = age;
    }

    public Person(String name, String dni, double weight, double height, int age) {
        this.name = name;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
        this.age = age;
    }

    public int calculateBMI() {
        double imc = weight / (Math.pow(height, 2));
        return (imc < 20) ? -1 : (imc <= 25) ? 0 : 1;

    }

    public boolean isAdult() {
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Nombre=" + name + "\nDNI=" + dni + "\nPeso=" + weight + "\nAltura=" + height + "\nEdad=" + age +  "\n";
    }
}
