public abstract class Prototipo<T extends Number> {
    protected T current;

    public abstract T getNextNumber();
    public abstract void reset();
    public abstract void setStart(T start);
}
