package org.example;

public class Participante {

    int numero_participante, dni, edad;
    String nombre, apellido, celular, numero_emergencia, grupo_sanguineo;

    static int contador_numero;

    public Participante(int dni, String nombre, String apellido, int edad, String celular, String numero_emergencia, String grupo_sanguineo){
        this.numero_participante = ++Participante.contador_numero;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

}
