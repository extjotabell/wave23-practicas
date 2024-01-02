package org.example;

public class Inscripcion {
    private int id;
    private Participante participante;
    private double valorInscripcion;
    private Categoria categoria;

    public Inscripcion(int id, Participante participante, double valorInscripcion, Categoria categoria) {
        this.id = id;
        this.participante = participante;
        this.valorInscripcion = valorInscripcion;
        this.categoria = categoria;
    }
}
