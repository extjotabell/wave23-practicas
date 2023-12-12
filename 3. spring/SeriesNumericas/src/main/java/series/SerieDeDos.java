package series;

public class SerieDeDos extends Prototipo<Double>{
    @Override
    public Double siguienteValor() {
        setActual(getActual()+2);
        System.out.println(getActual());
        return getActual();
    }
}
