public class Informe extends Documento {

    private String texto;
    private int paginas;
    private String autor;
    private String revisor;

    public Informe(String texto, int paginas, String autor, String revisor) {
        this.texto = texto;
        this.paginas = paginas;
        this.autor = autor;
        this.revisor = revisor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getRevisor() {
        return revisor;
    }

    public void setRevisor(String revisor) {
        this.revisor = revisor;
    }

    @Override
    public void imprimir() {
        System.out.println("Informe{" +
                "texto='" + texto + '\'' +
                ", paginas=" + paginas +
                ", autor='" + autor + '\'' +
                ", revisor='" + revisor + '\'' +
                '}');
    }
}
