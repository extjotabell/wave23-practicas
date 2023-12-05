package org.example;

public class Vehiculo {
    private double velocidad;
    private double aceleracion;
    private double anguloGiro;
    private String patente;
    private double peso;
    private int cantidadRuedas;

    public Vehiculo(){}

    public Vehiculo(double velocidad, double aceleracion, double anguloGiro, String patente, double peso, int cantidadRuedas) {
        this.velocidad = velocidad;
        this.aceleracion = aceleracion;
        this.anguloGiro = anguloGiro;
        this.patente = patente;
        this.peso = peso;
        this.cantidadRuedas = cantidadRuedas;
    }

    public String getPatente() {
        return patente;
    }

    public double calcularScore () {
        return (this.velocidad * (this.aceleracion / 2)) / (this.anguloGiro * (this.peso - this.cantidadRuedas * 100));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "velocidad=" + velocidad +
                ", aceleracion=" + aceleracion +
                ", anguloGiro=" + anguloGiro +
                ", patente='" + patente + '\'' +
                ", peso=" + peso +
                ", cantidadRuedas=" + cantidadRuedas +
                '}';
    }
}
