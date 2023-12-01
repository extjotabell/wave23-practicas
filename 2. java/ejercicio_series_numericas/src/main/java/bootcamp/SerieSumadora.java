package bootcamp;

public class SerieSumadora extends Prototipo {

    SerieSumadora(Number factor, Number inicial) {
        super(factor, inicial);
    }

    public Number siguiente() {
        this.current = (current.doubleValue() + factor.doubleValue());
        return current;
    }


}
