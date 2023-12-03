public abstract class Prototipo <T extends Number>{

    protected T valorInicial;
    protected T valorActual;
    protected T paso;

    public Prototipo(T inicial, T paso) {
        this.valorInicial = inicial;
        this.valorActual = inicial;
        this.paso = paso;
    }

    public abstract T siguiente();

    public void reiniciar() {
        this.valorActual = valorInicial;
    }

    public void establecerInicial(T valor) {
        this.valorInicial = valor;
        this.valorActual = valor;
    }


}
