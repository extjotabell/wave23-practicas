package bootcamp;

import java.awt.font.NumericShaper;

//Es posible usar genericos y considero que mejor, pero por razones didacticas lo harè de esta manera
public abstract class Prototipo {

    protected Number inicial;
    protected Number current;

    protected Number factor;

    Prototipo(Number factor, Number inicial) {
        this.factor = factor;
        this.estableceInicio(inicial);
    }
    public abstract Number siguiente();

    public void reiniciar() {
        current = inicial;
    }

    public void estableceInicio(Number inicial) {
        this.inicial = inicial;
        this.current = inicial;
    }
}
