package org.example;

public class Persona {
    private String name;
    private String dni;
    private int edad;
    private double peso;
    private double altura;

    public Persona() {
    }

    public Persona(String name, String dni, int edad) {
        this.name = name;
        this.dni = dni;
        this.edad = edad;
    }

    public Persona(String name, String dni, int edad, double peso, double altura) {
        this.name = name;
        this.dni = dni;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }

    public int calcularIMC(){
        double imc = peso/Math.pow(altura,2);
        if(imc<20){
            return -1;
        }else if (imc>= 20 && imc<=25){
            return 0;
        }
        return 1;
    }

    public boolean esMayorDeEdad(){
        return edad>18;
    }

    public String toString(){
        return "Nombre: "+name+"\n"+"Edad: "+edad+"\n"+"DNI: "+dni+"\n"+"Peso: "+peso+"\n"+"Altura: "+altura;
    }



}
