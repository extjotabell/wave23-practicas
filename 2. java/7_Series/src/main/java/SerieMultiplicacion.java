public class SerieMultiplicacion extends Serie {
    private int multiplicador;

    public SerieMultiplicacion(int inicio, int multiplicador) {
        super(inicio);
        this.multiplicador = multiplicador;
    }

    @Override
    public int calcularSiguiente() {
        this.valorSerie *= multiplicador;
        return this.valorSerie;
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
