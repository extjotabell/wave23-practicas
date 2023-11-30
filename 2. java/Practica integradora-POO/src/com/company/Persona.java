package com.company;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double estatura;
    double IMC;


    public Persona (){}

    public Persona (String nombre, int edad, String dni){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public Persona (String nombre, int edad, String dni, double peso, double estatura){
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
        this.peso = peso;
        this.estatura = estatura;
    }

    public double calcularIMC(){
        IMC = peso/(estatura*estatura);
        if(IMC < 20 ){
            return -1;
        } else if ( IMC >= 20 && IMC <=25){
            return  0;
        } else {
            return 1;
        }
    }

    public boolean esMayorDeEdad (){
        if(edad > 18){
            return  true;
        } else {
            return false;
        }
    }

}
