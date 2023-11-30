package org.example;

public class Persona {

    private String nombre, dni;
    private int edad;
    double peso, altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        if (this.altura != 0 || this.peso != 0) {
            double calculo = this.peso / (Math.pow(this.altura, 2));
            if (calculo < 20) {
                return -1;
            } else if (calculo <= 25) {
                return 0;
            } else {
                return 1;
            }

        } else {
            return 999;
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad >= 18) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}

