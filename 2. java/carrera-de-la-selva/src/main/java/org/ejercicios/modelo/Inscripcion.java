package org.ejercicios.modelo;

public class Inscripcion {

    private String id;
    private Categoria categoria;
    private Participante participante;
    private double monto;

    public Inscripcion(String id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = this.calcularMonto(participante, categoria);
    }

    private double calcularMonto(Participante participante, Categoria categoria) {
        if (categoria.getNombre().equals("Circuito chico")){
            if (participante.getEdad()< 18 ) return 1300;
            else return 1500;
        }
        if (categoria.getNombre().equals("Circuito medio")){
            if (participante.getEdad() < 18 ) return 2000;
            else return 2300;
        }
        if (categoria.getNombre().equals("Circuito avanzado")){
            if (participante.getEdad() > 18 ) return 2800;
            else return 0;
        }
        else return 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
}
