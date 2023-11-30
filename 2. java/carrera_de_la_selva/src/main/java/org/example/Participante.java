package org.example;

public class Participante {
    private  int nro,edad;
    private  String dni,nombre,apellido,celular,grupoSanguineo;

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public Participante(int nro, String dni, String nombre, String apellido, String celular, String grupoSanguineo, int edad) {
        this.nro = nro;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.grupoSanguineo = grupoSanguineo;
        this.edad = edad;
    }
}
