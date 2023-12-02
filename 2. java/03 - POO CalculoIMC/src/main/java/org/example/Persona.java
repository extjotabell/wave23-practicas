package org.example;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;
    private double peso;
    private double altura;

    public Persona() {
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


    public int cacularIMC(){
        int IMC = 0;
        double calculo = 0.0;
        calculo = this.peso/(Math.pow(this.altura,2));

        if(calculo < 20){
            IMC = -1;
        } else if (calculo >=20 && calculo <=25) {
            IMC = 0;
        }else{
            IMC =1;
        }

        return IMC;
    }

    public boolean esMayorDeEdad(){
        boolean flag = false;
        if(this.edad >= 18){
            flag = true;
        }
        return flag;
    }


    //Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "\n Nombre: " + nombre +
                " \nedad: " + edad +
                " \ndni: " + dni +
                " \npeso: " + peso +
                " \naltura: " + altura;
    }
}
