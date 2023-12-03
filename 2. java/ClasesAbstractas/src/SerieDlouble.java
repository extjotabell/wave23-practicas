public class SerieDlouble extends Prototype<Double>{
    public SerieDlouble(Double initialValue, Double serie) {
        super(initialValue, serie);
    }

    @Override
    protected Double increment() {
        return currentValue + serie;
    }
}
