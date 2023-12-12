package series;

public class SerieDeTres extends Prototipo<Double>{
    @Override
    public Double siguienteValor() {
        setActual(getActual()+3);
        System.out.println(getActual());
        return getActual();
    }
}
