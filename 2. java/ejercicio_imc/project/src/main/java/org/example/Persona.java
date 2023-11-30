package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    private double peso;
    private double altura; //Porque contienen decimales

    public Persona(){

    }

    public Persona(String nombre, int edad, String dni) {
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

    public int calcularIMC(){
        double aux = (peso/(Math.pow(altura,2)));

        if (aux<20){
            return -1;
        }
        else if (aux>=20 && aux<=25){
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean esMayorDeEdad(){
        return (edad>=18);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", dni='" + dni + '\'' +
                ", peso=" + peso +
                ", altura=" + altura +
                ", imc=" + calcularIMC() +
                ", Mayor de edad=" + esMayorDeEdad() +
                '}';
    }


}