package org.example;

public class Inscripcion extends Competencia {
    private int numero_inscripcion;

    public Inscripcion(int id, String nombre_circuito, String descripcion_circuito, int numero_inscripcion) {
        super(id, nombre_circuito, descripcion_circuito);
        this.numero_inscripcion = numero_inscripcion;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "numero_inscripcion=" + numero_inscripcion;
    }

    public int getNumero_inscripcion() {
        return numero_inscripcion;
    }

    public void setNumero_inscripcion(int numero_inscripcion) {
        this.numero_inscripcion = numero_inscripcion;
    }
}
