package org.example;

import java.util.Objects;

public class Participante extends Inscripcion{
    private int numero_participante;
    private int dni;
    private String nombre_participante;
    private String apellido_participante;
    private int edad;
    private String celular;
    private String numero_emergencia;
    private String grupo_sanguineo;

    public Participante(int id, String nombre_circuito, String descripcion_circuito, int numero_inscripcion, int numero_participante, int dni, String nombre_participante, String apellido_participante, int edad, String celular, String numero_emergencia, String grupo_sanguineo) {
        super(id, nombre_circuito, descripcion_circuito, numero_inscripcion);
        this.numero_participante = numero_participante;
        this.dni = dni;
        this.nombre_participante = nombre_participante;
        this.apellido_participante = apellido_participante;
        this.edad = edad;
        this.celular = celular;
        this.numero_emergencia = numero_emergencia;
        this.grupo_sanguineo = grupo_sanguineo;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "numero_participante=" + numero_participante +
                ", dni=" + dni +
                ", nombre_participante='" + nombre_participante + '\'' +
                ", apellido_participante='" + apellido_participante + '\'' +
                ", edad=" + edad +
                ", celular='" + celular + '\'' +
                ", numero_emergencia='" + numero_emergencia + '\'' +
                ", grupo_sanguineo='" + grupo_sanguineo + '\'' +
                '}';
    }

    public int getNumero_participante() {
        return numero_participante;
    }

    public void setNumero_participante(int numero_participante) {
        this.numero_participante = numero_participante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre_participante() {
        return nombre_participante;
    }

    public void setNombre_participante(String nombre_participante) {
        this.nombre_participante = nombre_participante;
    }

    public String getApellido_participante() {
        return apellido_participante;
    }

    public void setApellido_participante(String apellido_participante) {
        this.apellido_participante = apellido_participante;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNumero_emergencia() {
        return numero_emergencia;
    }

    public void setNumero_emergencia(String numero_emergencia) {
        this.numero_emergencia = numero_emergencia;
    }

    public String getGrupo_sanguineo() {
        return grupo_sanguineo;
    }

    public void setGrupo_sanguineo(String grupo_sanguineo) {
        this.grupo_sanguineo = grupo_sanguineo;
    }

    public int montoInscripcion(){
        int monto = 0;
        if (edad<18 && Objects.equals(getNombre_circuito(), "Circuito Chico")){
            monto = 1300;
        }
        else if (edad>=18 && Objects.equals(getNombre_circuito(), "Circuito Chico")){
            monto = 1500;
        }
        else if (edad<18 && Objects.equals(getNombre_circuito(), "Circuito Medio")){
            monto = 2000;
        }
        else if (edad>=18 && Objects.equals(getNombre_circuito(), "Circuito Medio")){
            monto = 2300;
        }
        else if (edad<18 && Objects.equals(getNombre_circuito(), "Circuito Avanzado")){
            monto = 0;
        }
        else if (edad>=18 && Objects.equals(getNombre_circuito(), "Circuito Avanzado")){
            monto = 2800;
        }
        return monto;
    }
}
