package org.example;

public class Participante {
    private int id_participante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numeroEmergencia;
    private String grupoSanguineo;

    public Participante(int id_participante, int dni, String nombre, String apellido, int edad, int celular, int numeroEmergencia, String grupoSanguineo) {
        this.id_participante = id_participante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numeroEmergencia = numeroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }
}
