package org.ejercicio.ejerciciodos.modelo.impl;

public class Informe extends Documento{
    String texto;
    int longitudTexto;
    int cantidadDePaginas;
    String autor;
    String revisor;

    public Informe(String id, String texto, int longitudTexto, int cantidadDePaginas, String autor, String revisor) {
        super(id);
        this.texto = texto;
        this.longitudTexto = longitudTexto;
        this.cantidadDePaginas = cantidadDePaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Informe{" +
                "texto='" + texto + '\'' +
                ", longitudTexto=" + longitudTexto +
                ", cantidadDePaginas=" + cantidadDePaginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}';
    }
}
