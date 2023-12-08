package bootcamp;

import java.awt.font.NumericShaper;

//Es posible usar genericos y considero que mejor, pero por razones didacticas lo harè de esta manera
public abstract class Prototipo<T extends Number> {

    protected T inicial;
    protected T current;

    protected T factor;

    Prototipo(T factor, T inicial) {
        this.factor = factor;
        this.estableceInicio(inicial);
    }
    public abstract T siguiente();

    public void reiniciar() {
        current = inicial;
    }

    public void estableceInicio(T inicial) {
        this.inicial = inicial;
        this.current = inicial;
    }
}
