package org.example;

public class Persona {

    private String nombre;

    private int edad;

    private String dni;

    private double peso;

    private double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = (this.peso)/(this.altura * this.altura);
        if (imc < 20){
            return -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return edad >= 18;
    }

    @Override
    public String toString() {
        return "Persona: \n"
                + "-Nombre= " + nombre + "\n"
                + "-Edad= " + edad + "\n"
                +"-Dni= " + dni + "\n"
                +"-Peso= " + peso + "\n"
                +"-Altura= " + altura;
    }



}
