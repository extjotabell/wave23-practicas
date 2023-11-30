package main;

import java.util.Set;

public class Inscripcion {

    private int nroInscripcion;
    private Categoria categoria;
    private Participante participante;
    private double monto;


    public Categoria getCategoria() {
        return categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public Inscripcion(int nroInscripcion, Categoria categoria, Participante participante, double monto) {
        this.nroInscripcion = nroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }
}
