package org.example;

public class Inscripcion {
    private int id;
    private Categoria categoria;
    private Participante participante;


    private double monto;

    public Inscripcion(int id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        this.monto =this.calcularMonto(participante, categoria);
    }

    private double calcularMonto(Participante participante, Categoria categoria){
        if (categoria.getNombre().equals("Circuito chico")){
            if(participante.getEdad()< 18){
                return 1300;
            } else {
                return 1500;
            }
        }
        if (categoria.getNombre().equals("Circuito mediano")){
            if(participante.getEdad()< 18){
                return 2000;
            } else {
                return 2300;
            }
        }
        if (categoria.getNombre().equals("Circuito avanzado")) {
            if (participante.getEdad() > 18) {
                return 2800;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }


}
