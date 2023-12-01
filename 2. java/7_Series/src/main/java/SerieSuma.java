public class SerieSuma extends Serie {

    private int aumento;
    public SerieSuma(int inicio, int aumento) {
        super(inicio);
        this.aumento = aumento;
    }

    @Override
    public int calcularSiguiente() {
        this.valorSerie += aumento;
        return valorSerie;
    }

    @Override
    public void reiniciarSerie() {
        this.valorSerie = this.inicio;
    }

    @Override
    public void establecerInicio(int nuevoInicio) {
        this.inicio = nuevoInicio;
    }
}
