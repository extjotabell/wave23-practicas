public class SerieInteger extends Prototype<Integer>{
    public SerieInteger(Integer initialValue, Integer serie) {
        super(initialValue, serie);
    }

    @Override
    protected Integer increment() {
        return currentValue + serie;
    }
}
