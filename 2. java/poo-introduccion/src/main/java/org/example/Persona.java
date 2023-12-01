package org.example;

public class Persona {
    String nombre;
    int edad;
    String dni;
    double peso;
    double altura;

    public Persona(){}

    public Persona(String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona(String nombre, int edad, String dni, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC() {
        double imc = peso/(Math.pow(altura, 2));
        if (imc < 20) {
            return  -1;
        } else if (imc >= 20 && imc <= 25) {
            return 0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String mostrarIMC() {
        switch (calcularIMC()) {
            case -1 -> {
                return "Bajo peso";
            }
            case 0 -> {
                return "Peso saludable";
            }
            case 1 -> {
                return "Sobrepeso";
            }
            default -> {
                return "No se logró calcular el índice de masa corporal";
            }
        }
    }

        @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nEs mayor de edad: " + (esMayorDeEdad() ? "Si" : "No") +
                "\nDni: " + dni +
                "\nAltura: " + altura +
                "\nPeso: " + peso +
                "\nIMC: " + mostrarIMC();
    }
}
