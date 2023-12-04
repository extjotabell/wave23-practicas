public class PrototipoInteger extends Prototipo<Integer>{
    private Integer startValue = 0;
    private final Integer JUMP_VALUE = 2;
    @Override
    public Integer getNextNumber() {
        current += JUMP_VALUE;
        return current;
    }

    @Override
    public void reset() {
        current = startValue;
    }

    @Override
    public void setStart(Integer start) {
        startValue = start;
    }
}
