package org.example;

public class Inscripcion {

    int numeroInscripcion;
    Categoria categoria;
    Participante participante;
    double monto;
    public Inscripcion(int numeroInscripcion, Categoria categoria, Participante participante) {
        this.numeroInscripcion = numeroInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = this.calcularMonto();
    }

    private int calcularMonto() {
        int edad = participante.edad;
        switch (categoria.nombre) {
            case "Circuito chico" -> {
                if (edad < 18) {
                    return 1300;
                } else {
                    return 1500;
                }
            }

            case "Circuito medio" -> {
                if (edad < 18) {
                    return 2000;
                } else {
                    return 2300;
                }
            }

            case "Circuito avanzado" -> {
                if (edad < 18) {
                    System.out.println("ERROR - No se permite inscripciones a menores de 18 años al Circuito Avanzado");
                } else {
                    return 2800;
                }
            }
            default -> {
                System.out.println("ERROR - La categoría es incorrecta, reintente nuevamente");
            }
        }
        return 0;
    }

    @Override
    public String toString(){
        return "N° de inscripcion: " + numeroInscripcion + " Participante: " + participante.getFullName();
    }
}