package org.example;

public class Participante {
    int numeroParticipante;
    int dni;
    String nombre;
    String apellido;
    int edad;
    int telefono;
    int telefonoEmergencia;
    String grupoSanguineo;

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, int telefono, int telefonoEmergencia, String grupoSanguineo) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
        this.telefonoEmergencia = telefonoEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getFullName() {
        return this.nombre + " " + this.apellido;
    }
}
