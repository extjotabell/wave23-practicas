package main;

public class Participante {

    private int nroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int nroEmergencia;
    private String grupoSanguineo;

    public Participante(int nroParticipante, int dni, String nombre, String apellido, int edad, int celular, int nroEmergencia, String grupoSanguineo) {
        this.nroParticipante = nroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.nroEmergencia = nroEmergencia;
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getNroParticipante() {
        return nroParticipante;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public int getCelular() {
        return celular;
    }

    public int getNroEmergencia() {
        return nroEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }
}
