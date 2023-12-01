public abstract class Serie {

    public int inicio;
    public int valorSerie;

    public Serie(int inicio) {
        this.inicio = inicio;
        this.valorSerie = inicio;
    }

    public abstract int calcularSiguiente();
    public abstract void reiniciarSerie();
    public abstract void establecerInicio(int nuevoInicio);

}
