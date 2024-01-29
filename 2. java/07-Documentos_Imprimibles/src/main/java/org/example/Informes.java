package org.example;

public class Informes extends Documento{
    String Observaciones;
    int cantidadPagos;
    String autor;
    String titulo;
    String revisor;

    public Informes(String Observaciones, int cantidadPagos, String autor, String titulo, String revisor) {
        this.Observaciones = Observaciones;
        this.cantidadPagos = cantidadPagos;
        this.autor = autor;
        this.titulo = titulo;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor );
        System.out.println("Revisor: " + revisor);
        System.out.println("Observaciones" + Observaciones);
        System.out.println("Numero de Pagos" + cantidadPagos);

    }

    @Override
    public void imprimirTipoDocumento() {

    }
}
