public abstract  class Prototype<N extends Number> {
    protected N initialValue;
    protected N serie;
    protected N currentValue;

    public Prototype(N initialValue, N serie) {
        this.initialValue = initialValue;
        this.serie = serie;
        this.currentValue = initialValue;
    }

    protected abstract N increment();

    public N next() {
        currentValue = increment();
        return currentValue;
    }

    public void resetSerie() {
        currentValue = initialValue;
    }

    public void setValue(N value){
        this.initialValue = value;
        this.resetSerie();
    };
}
