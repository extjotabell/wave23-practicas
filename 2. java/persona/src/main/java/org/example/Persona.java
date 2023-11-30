package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private int dni;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, int dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, int dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public boolean esMayorDeEdad(){
        return this.edad >= 18;
    }
    public int calcularIMC(){
        double imc = this.peso / Math.pow(this.altura, 2);
        if (imc < 20) {
            return -1;
        } else if (imc>= 20 && imc <=25) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Persona: " +
                "Nombre=" + nombre +
                ", Edad=" + edad +
                ", dni=" + dni +
                ", Peso=" + peso +
                ", Altura=" + altura;
    }
}


