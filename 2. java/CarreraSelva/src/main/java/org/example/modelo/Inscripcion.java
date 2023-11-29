package org.example.modelo;

public class Inscripcion {

    private int numeroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante, int monto) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }

    public int getNumeroInscripcion() {
        return numeroInscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public int getMonto() {
        return monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numeroInscripcion=" + numeroInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
