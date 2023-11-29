package org.example.modelo;

public class Inscripcion {

    private static int numeroInscripcion = 0;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public Inscripcion(Categoria categoria, Participante participante) {
        this.categoria = categoria;
        this.participante = participante;
        this.calcularMontoInscripcion();
        numeroInscripcion++;
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

    private void calcularMontoInscripcion() {
        int montoBase = 0;

        switch (categoria.getNombre()) {
            case "Circuito chico":
                if (participante.getEdad() < 18) {
                    montoBase = 1300;
                } else {
                    montoBase = 1500;
                }
                break;
            case "Circuito medio":
                if (participante.getEdad() < 18) {
                    montoBase = 2000;
                } else {
                    montoBase = 2300;
                }
                break;
            case "Circuito avanzado":
                if (participante.getEdad() < 18) {
                    throw new IllegalArgumentException("No se permite la inscripción de menores de 18 años a la categoría Circuito Avanzado");
                } else {
                    montoBase = 2800;
                }
                break;
        }

        this.monto = montoBase;
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
