package org.example;

import java.util.List;
import java.util.Random;

public class Inscripcion {

    private int id;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(Categoria categoria, Participante participante, Carrera carrera) throws IllegalArgumentException {

        if (participanteEstaInscrito(participante, carrera.getInscripcionList())) {
            throw new IllegalArgumentException("El participante ya está inscrito en otra categoría.");
        }

        this.id = new Random().nextInt(1000);
        this.categoria = categoria;
        this.participante = participante;

        try {
            this.monto = calcularMonto();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            throw new IllegalArgumentException("Error al calcular el monto de inscripción.");
        }
    }


    private double calcularMonto() {
        switch (this.categoria.getNombre().toLowerCase()) {
            case "circuito chico":
                return (this.participante.getEdad() < 18) ? 1300 : 1500;
            case "circuito medio":
                return (this.participante.getEdad() < 18) ? 2000 : 2300;
            case "circuito avanzado":
                if (this.participante.getEdad() >= 18) {
                    return 2800;
                } else {
                    throw new IllegalArgumentException("No se permite inscripciones a menores de 18 años en la categoría Avanzado.");
                }
            default:
                return 0;
        }
    }

    public boolean participanteEstaInscrito(Participante participante, List<Inscripcion> inscripciones) {

    for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getParticipante().equals(participante)) {
                return true;
            }
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "\nInscripcion: " + id +
                ", \nCategoria: " + categoria.getNombre() +
                ", \nParticipante: " + participante.getNombre() +
                ", \nMonto: " + monto;
    }
}
