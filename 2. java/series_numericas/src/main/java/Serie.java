public abstract class Serie<T extends Number> {
    T inicio;
    T salto;

    int i = -1;

    public Serie(T inicio, T salto) {
        this.inicio = inicio;
        this.salto = salto;
    }

    public abstract T siguiente();
    public abstract void reiniciar();
    public abstract void setInicio(T inicio);
}
