package bootcamp;

public class SerieDoubleExponenciadora extends Prototipo<Double>{
    SerieDoubleExponenciadora(Double factor, Double inicial) {
        super(factor, inicial);
    }

    @Override
    public Double siguiente() {
        this.current = Math.pow(current, factor);
        return current;
    }
}
