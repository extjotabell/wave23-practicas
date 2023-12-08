package bootcamp;

public class SerieMultiplicadora<T extends Number> extends Prototipo<T> {

    SerieMultiplicadora(T factor, T inicial) {
        super(factor, inicial);
    }

    public T siguiente() {
        //This could throw a Dynamic Cast Exception
        this.current = (T) (Number) (current.doubleValue() * factor.doubleValue());
        return current;
    }


}
