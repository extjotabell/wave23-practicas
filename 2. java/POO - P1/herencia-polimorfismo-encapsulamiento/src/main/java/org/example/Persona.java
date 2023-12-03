package org.example;

public class Persona {
    private String nombre;
    private String dni;
    private int edad;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String nombre, String dni, int edad) {
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

    public String nivelPeso(){
        int imc = this.calcularIMC();

        if(imc == -1) {
            return "Bajo Peso";
        }

        if(imc == 0) {
            return "Peso Normal";
        }

        return "Sobrepeso";
    }
    private int calcularIMC(){
        double imc = this.peso/(this.altura * this.altura);

        if(imc < 20){
            return -1;
        }

        if(imc >=20 && imc <=25){
            return 0;
        }

        return 1;
    }

    public boolean esMayorDeEdad(){
        return (this.edad >= 18);
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