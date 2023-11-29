package org.example;

public class Inscripcion {
    private int id;
    private Participante participante;
    private double total;
    private Categoria categoria;
    public double getTotal() {
        return total;
    }

    public Inscripcion(int id, Participante participante, Categoria categoria) {
        this.id = id;
        this.participante = participante;
        this.categoria = categoria;
        this.total = getValorInscripcion();
    }

    private double getValorInscripcion() {
        if (this.categoria.getNombre().equals("Circuito chico")) {
            if (this.participante.getEdad() < 18) {
                return 1300;
            }else{
                return 1500;
            }
        }

        if (this.categoria.getNombre().equals("Circuito medio")) {
            if (this.participante.getEdad() < 18) {
                return 2000;
            }else{
                return 2300;
            }
        }

        if (this.categoria.getNombre().equals("Circuito avanzado")) {
            if (this.participante.getEdad() > 18) {
             return 2800;
            }
        }
        return -1;
    }

    public void MostrarDatos(){
        System.out.println("Categoria " + this.categoria.getNombre() + "\nnro inscripcion " + this.id + "\nnombre participante " + this.participante.getNombre() + "\ncosto total " + this.total) ;
    }
}
