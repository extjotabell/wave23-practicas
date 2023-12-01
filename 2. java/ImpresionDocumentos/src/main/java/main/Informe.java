package main;

public class Informe extends DocumentoImpl {
    private String texto;
    private int cantPaginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int cantPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo informe:");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Informe:\n" +
                "Texto: " + texto + "\n" +
                "Cantidad de páginas: " + cantPaginas + "\n" +
                "Autor: " + autor + "\n" +
                "Revisor: " + revisor;
    }
}
