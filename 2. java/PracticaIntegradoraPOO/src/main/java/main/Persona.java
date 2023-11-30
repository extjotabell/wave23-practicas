package main;

public class Persona {
    private String name;
    private int age;
    private String dni;
    private double weight;
    private double height;

    public Persona() {
    }

    public Persona(String name, int age, String dni) {
        this.name = name;
        this.age = age;
        this.dni = dni;
    }

    public Persona(String name, int age, String dni, double weight, double height) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.weight = weight;
        this.height = height;
    }
    public int calcularIMC(){
        double imc = weight / Math.pow(height,2);
        return imc < 20 ? -1 : imc <= 25 ? 0 : 1;
    }
    public boolean mayorDeEdad(){
        return age >= 18;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", age=" + age +
                ", dni='" + dni + '\'' +
                ", weight=" + weight +
                ", height=" + height;
    }
}
