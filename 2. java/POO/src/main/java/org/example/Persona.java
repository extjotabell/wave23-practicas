package org.example;

public class Persona {
    String nombre, dni;
    int edad;
    double peso, altura;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String nombre, String dni, int edad, double peso, double altura) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    private int calcularIMC() {
        double imc = this.peso / Math.pow(this.altura, 2);

        if (imc < 20) {
            return -1;
        }

        if (imc >= 20 && imc <= 25) {
            return 0;
        }

        return 1;
    }

    private boolean esMayorDeEdad() {
        return this.edad >= 18;
    }

    public String nivelPeso(){
       return switch (calcularIMC()){
           case -1 -> "Bajo Peso.";
           case 0 -> "Peso saludable.";
           case 1 -> "Sobrepeso.";
           default -> "No definido.";
       };
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", altura=" + altura +
                ", es mayor de edad: " + (esMayorDeEdad() ? "Si." : "No.") +
                ", nivel de peso: " + nivelPeso() +
                '}';
    }


}
