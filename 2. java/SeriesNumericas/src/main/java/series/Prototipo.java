package series;

abstract class Prototipo<T extends Number> {

    private T actual=(T) Double.valueOf(0);
    private T inicio=(T) Double.valueOf(0);
    public abstract T siguienteValor();

    public void valorInicial(T inicio){
        this.inicio=inicio;
    }

    public void reiniciarSerie(){
        System.out.println("Se reinicia la serie al inicio");
        actual=inicio;
    }

    public T getActual() {
        return actual;
    }

    public void setActual(T actual) {
        this.actual = actual;
    }

    public T getInicio() {
        return inicio;
    }

    public void setInicio(T inicio) {
        this.inicio = inicio;
    }
}
