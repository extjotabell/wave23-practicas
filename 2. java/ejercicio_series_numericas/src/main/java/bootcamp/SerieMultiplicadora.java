package bootcamp;

public class SerieMultiplicadora extends Prototipo {

    SerieMultiplicadora(Number factor, Number inicial) {
        super(factor, inicial);
    }

    public Number siguiente() {
        this.current = (current.doubleValue() * factor.doubleValue());
        return current;
    }


}
