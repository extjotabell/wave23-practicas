public class Informe implements  Imprimible{

    String texto;
    int cantidadPaginas;
    String autor;
    String revisor;

    public Informe(String texto, int cantidadPaginas, String autor, String revisor) {
        this.texto = texto;
        this.cantidadPaginas = cantidadPaginas;
        this.autor = autor;
        this.revisor = revisor;
    }



    @Override
    public void imprimir() {
        System.out.println("Texto: " + texto);
        System.out.println("Cantidad de Páginas: " + cantidadPaginas);
        System.out.println("Autor: " + autor);
        System.out.println("Revisor: " + revisor);
    }
}
