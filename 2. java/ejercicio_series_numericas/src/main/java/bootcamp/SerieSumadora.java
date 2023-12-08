package bootcamp;

public class SerieSumadora<T extends Number> extends Prototipo<T> {

    SerieSumadora(T factor, T inicial) {
        super(factor, inicial);
    }

    public T siguiente() {
        //This could throw a Dynamic Cast Exception
        this.current = (T) (Number) (current.doubleValue() + factor.doubleValue());
        return current;
    }


}
