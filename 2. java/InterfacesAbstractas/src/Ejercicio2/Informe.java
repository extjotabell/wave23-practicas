package Ejercicio2;

public class Informe implements Imprimir{
    private String texto;
    private int cantPaginas;
    private String revisor;

    public Informe(String texto, int cantPaginas, String revisor) {
        this.texto = texto;
        this.cantPaginas = cantPaginas;
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Detalle del informe: \n" +
                "Texto: '" + texto + '\n' +
                "Cant. Paginas: " + cantPaginas + '\n' +
                "Revisor: '" + revisor );
    }
}
