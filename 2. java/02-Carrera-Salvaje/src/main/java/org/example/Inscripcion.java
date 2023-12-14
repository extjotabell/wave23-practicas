package org.example;

public class Inscripcion {
    private int  id_inscripcion;
    private Categoria categoria;
    private Participante participante;
    private static int nextId;
    private double monto;

    public Inscripcion(int id_inscripcion, Categoria categoria, Participante participante) {
        if(categoria.getDescripcion().equals("avanzado") && participante.getEdad() < 18){
            System.out.println("Error al insribir participantes menores de edad a circuito avanzado.");
        }
        this.id_inscripcion = ++nextId;
        this.categoria = categoria;
        this.participante = participante;
        calcular_monto(participante,categoria);
    }

    public double getMonto() {
        return monto;
    }

    private double calcular_monto(Participante participante, Categoria categoria){
        if (categoria.getDescripcion() == "chico"){
            if (participante.getEdad() < 18){
                monto = 1300;
            }else {
                monto = 1500;
            }
        if(categoria.getDescripcion() == "medio"){
            if (participante.getEdad() < 18){
                monto = 2000;
            }else {
                monto = 2300;
            }
        }
        if(categoria.getDescripcion() == "avanzado"){
            if (participante.getEdad() < 18){
                System.out.println("Error no se puede inscribir participantes menores de 18 años");
            }else {
                monto = 2800;
            }
        }

        }
        return monto;

    }
}
